package de.ytendx.mccloud.master.management;

import de.ytendx.mccloud.api.entity.ServiceGroupModel;
import de.ytendx.mccloud.api.service.Service;
import de.ytendx.mccloud.api.service.ServiceType;
import de.ytendx.mccloud.api.service.impl.BukkitService;
import de.ytendx.mccloud.api.ticker.TickingService;
import de.ytendx.mccloud.common.redisservice.requesting.service.ServiceStartRequestQuestion;
import de.ytendx.mccloud.common.service.AbstractServiceGroup;
import de.ytendx.mccloud.common.service.ServiceTempConfigImpl;
import de.ytendx.mccloud.master.RunningMaster;
import de.ytendx.mccloud.master.service.ProxyMasterServiceGroupImpl;

public class ServiceManager implements TickingService {

    private final RunningMaster runningMaster;
    private final RunnerManager runnerManager;

    public ServiceManager(RunningMaster runningMaster, RunnerManager runnerManager) {
        this.runningMaster = runningMaster;
        this.runnerManager = runnerManager;
    }

    @Override
    public void tick(){
        for(ServiceGroupModel serviceGroupModelEntity : runningMaster.getServiceGroupRepository().findAll()){
            if(serviceGroupModelEntity.getType().equals(ServiceType.SPIGOT)){
                AbstractServiceGroup<BukkitService> serviceGroup = (AbstractServiceGroup<BukkitService>) runningMaster.getGeneralRedisContainer().getBukkitServices().get(serviceGroupModelEntity.name());

                if(serviceGroup.minOnlineServices() > serviceGroup.onlineServices()){

                    int toStart = serviceGroup.minOnlineServices() - serviceGroup.onlineServices();

                    for(int started = 0; started < toStart; started++){
                        //TODO: Add logging
                        Service service = serviceGroup.createService(new ServiceTempConfigImpl(serviceGroupModelEntity.maxPlayers(),
                                serviceGroupModelEntity.maxPoolMemory() / serviceGroupModelEntity.maxOnlineServices(),
                                serviceGroupModelEntity.name() + "-" + serviceGroup.onlineServices() + started + 1,
                                serviceGroup.displayName()
                        ));
                        runnerManager.getRedisServiceStartRequestPoolByLeastUsedRunnerManagementService()
                                .request(new ServiceStartRequestQuestion(serviceGroup.name(), service), serviceStartRequestAnswer -> {
                                    // TODO: Add logging
                                });
                    }
                }

            }else{
                if(!runningMaster.getGeneralRedisContainer().getProxyServices().containsKey(serviceGroupModelEntity.name())){
                    runningMaster.getGeneralRedisContainer().getProxyServices().put(serviceGroupModelEntity.name(), new ProxyMasterServiceGroupImpl(serviceGroupModelEntity));
                }
            }
        }
    }
}
