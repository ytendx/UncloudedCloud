package de.ytendx.mccloud.master.management;

import de.ytendx.mccloud.api.entity.ServiceGroupModel;
import de.ytendx.mccloud.api.redis.requesting.RedisRequestPool;
import de.ytendx.mccloud.api.service.impl.BukkitService;
import de.ytendx.mccloud.master.RunningMaster;
import de.ytendx.mccloud.master.service.BukkitMasterServiceGroupImpl;

public class ServiceManager {

    private RunningMaster runningMaster;

    public ServiceManager(RunningMaster runningMaster) {
        this.runningMaster = runningMaster;
    }

    public void tick(){
        for(ServiceGroupModel serviceGroupModelEntity : runningMaster.getServiceGroupRepository().findAll()){
            if(!runningMaster.getGeneralRedisContainer().getBukkitServices().containsKey(serviceGroupModelEntity.name())){
                runningMaster.getGeneralRedisContainer().getBukkitServices().put(serviceGroupModelEntity.name(), new BukkitMasterServiceGroupImpl(serviceGroupModelEntity));
            }
        }
    }
}
