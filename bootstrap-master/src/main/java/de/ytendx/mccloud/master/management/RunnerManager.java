package de.ytendx.mccloud.master.management;

import de.ytendx.mccloud.api.entity.ServiceGroupModel;
import de.ytendx.mccloud.api.management.RunningCloudManagementService;
import de.ytendx.mccloud.api.management.impl.RunningRunnerCloudService;
import de.ytendx.mccloud.api.redis.requesting.RedisRequestPool;
import de.ytendx.mccloud.api.service.ServiceType;
import de.ytendx.mccloud.api.service.impl.BukkitService;
import de.ytendx.mccloud.api.ticker.TickingService;
import de.ytendx.mccloud.common.redis.requesting.RedisRequestPoolImpl;
import de.ytendx.mccloud.common.redisservice.requesting.service.ServiceStartRequestAnswer;
import de.ytendx.mccloud.common.redisservice.requesting.service.ServiceStartRequestQuestion;
import de.ytendx.mccloud.common.service.AbstractServiceGroup;
import de.ytendx.mccloud.common.service.ServiceTempConfigImpl;
import de.ytendx.mccloud.master.RunningMaster;
import de.ytendx.mccloud.master.management.watcher.StatusMaintainer;
import de.ytendx.mccloud.master.service.BukkitMasterServiceGroupImpl;
import de.ytendx.mccloud.master.service.ProxyMasterServiceGroupImpl;
import org.redisson.api.map.event.EntryCreatedListener;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RunnerManager implements TickingService {

    private final RunningMaster runningMaster;
    private final StatusMaintainer statusMaintainer;
    private final Map<RunningRunnerCloudService, RedisRequestPool<ServiceStartRequestQuestion, ServiceStartRequestAnswer>> serviceStartRequestPool;

    public RunnerManager(RunningMaster runningMaster) {
        this.runningMaster = runningMaster;
        this.statusMaintainer = runningMaster.getStatusMaintainer();
        this.serviceStartRequestPool = new ConcurrentHashMap<>();

        runningMaster.getManagementRedisContainer().getManagementServices().addListener((EntryCreatedListener<String, RunningCloudManagementService>) event -> {
            if(event.getValue() instanceof RunningRunnerCloudService service){
                serviceStartRequestPool.put(service,
                        new RedisRequestPoolImpl<>(runningMaster.getRedissonClientProvider(), "service-start_" + event.getKey(), ServiceStartRequestAnswer.class));
            }
        });

        runningMaster.getManagementRedisContainer().getManagementServices().addListener((EntryCreatedListener<String, RunningCloudManagementService>) event -> {
            if(event.getValue() instanceof RunningRunnerCloudService service){
                serviceStartRequestPool.remove(service);
            }
        });
    }

    public RunningRunnerCloudService runnerByUID(String id){
        return serviceStartRequestPool.keySet().stream()
                .filter(service -> service.uid().equals(id))
                .findAny()
                .orElse(null);
    }

    public RedisRequestPool<ServiceStartRequestQuestion, ServiceStartRequestAnswer> getRedisServiceStartRequestPoolByRunnerUID(String id){
        return getRedisServiceStartRequestPoolByRunner(runnerByUID(id));
    }

    public RedisRequestPool<ServiceStartRequestQuestion, ServiceStartRequestAnswer> getRedisServiceStartRequestPoolByRunner(RunningRunnerCloudService runnerCloudService){
        return serviceStartRequestPool.get(runnerCloudService);
    }

    public RedisRequestPool<ServiceStartRequestQuestion, ServiceStartRequestAnswer> getRedisServiceStartRequestPoolByLeastUsedRunnerManagementService(){
        return getRedisServiceStartRequestPoolByRunnerUID(statusMaintainer.getRunnerUIDFromLeastUsedRunnerManagementService());
    }

    @Override
    public void tick() {
        for(ServiceGroupModel serviceGroupModelEntity : runningMaster.getServiceGroupRepository().findAll()){
            if(serviceGroupModelEntity.getType().equals(ServiceType.SPIGOT)){
                if(!runningMaster.getGeneralRedisContainer().getBukkitServices().containsKey(serviceGroupModelEntity.name())){
                    runningMaster.getGeneralRedisContainer().getBukkitServices().put(serviceGroupModelEntity.name(), new BukkitMasterServiceGroupImpl(serviceGroupModelEntity));
                }
            }else{
                if(!runningMaster.getGeneralRedisContainer().getProxyServices().containsKey(serviceGroupModelEntity.name())){
                    runningMaster.getGeneralRedisContainer().getProxyServices().put(serviceGroupModelEntity.name(), new ProxyMasterServiceGroupImpl(serviceGroupModelEntity));
                }
            }
        }
    }
}
