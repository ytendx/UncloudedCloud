package de.ytendx.mccloud.master.management;

import de.ytendx.mccloud.api.ticker.TickingService;
import de.ytendx.mccloud.master.RunningMaster;

public class ServiceManager implements TickingService {

    private final RunningMaster runningMaster;
    private final RunnerManager runnerManager;

    public ServiceManager(RunningMaster runningMaster, RunnerManager runnerManager) {
        this.runningMaster = runningMaster;
        this.runnerManager = runnerManager;
    }

    @Override
    public void tick(){
//        for(var serviceGroupModelEntity : runningMaster.getServiceGroupRepository().findAll()){
//            var serviceGroup = serviceGroupModelEntity.getType().equals(ServiceType.SPIGOT) ?
//                    (AbstractServiceGroup<BukkitService>) runningMaster.getGeneralRedisContainer().getBukkitServices().get(serviceGroupModelEntity.name()) :
//                    (AbstractServiceGroup<ProxyService>) runningMaster.getGeneralRedisContainer().getProxyServices().get(serviceGroupModelEntity.name());
//
//            if(serviceGroup.minOnlineServices() > serviceGroup.onlineServices()){
//
//                int toStart = serviceGroup.minOnlineServices() - serviceGroup.onlineServices();
//
//                for(int started = 0; started < toStart; started++){
//                    //TODO: Add logging
//
//                    final var serviceTempConfig = new ServiceTempConfigImpl(serviceGroupModelEntity.maxPlayers(),
//                            serviceGroupModelEntity.maxPoolMemory() / serviceGroupModelEntity.maxOnlineServices(),
//                            serviceGroupModelEntity.name() + "-" + serviceGroup.onlineServices() + started + 1, // Later make this configurable?
//                            serviceGroup.displayName()
//                    );
//                    final var service = serviceGroup.createService(serviceTempConfig);
//
//                    runnerManager.getRedisServiceStartRequestPoolByLeastUsedRunnerManagementService()
//                            .request(new ServiceStartRequestQuestion(serviceGroup.name(), service), serviceStartRequestAnswer -> {
//                                // TODO: Add logging
//                            });
//                }
//            }
//        }
    }
}
