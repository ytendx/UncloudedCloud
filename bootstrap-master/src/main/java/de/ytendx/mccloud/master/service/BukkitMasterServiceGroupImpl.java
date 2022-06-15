package de.ytendx.mccloud.master.service;

import de.ytendx.mccloud.api.entity.ServiceGroupModel;
import de.ytendx.mccloud.api.service.Service;
import de.ytendx.mccloud.api.service.ServiceType;
import de.ytendx.mccloud.api.service.config.ServiceTempConfig;
import de.ytendx.mccloud.api.service.impl.BukkitService;
import de.ytendx.mccloud.common.service.AbstractServiceGroup;

public class BukkitMasterServiceGroupImpl extends AbstractServiceGroup<BukkitService> {
    public BukkitMasterServiceGroupImpl(String name, String displayName, int maxPoolMemory, int maxOnlineServices, int minOnlineServices, int maxOnlinePlayers, boolean staticGroup, ServiceType serviceType) {
        super(name, displayName, maxPoolMemory, maxOnlineServices, minOnlineServices, maxOnlinePlayers, staticGroup, serviceType);
    }

    public BukkitMasterServiceGroupImpl(ServiceGroupModel groupModel) {
        super(groupModel);
    }

    @Override
    public Service createService(ServiceTempConfig serviceConfig) {
        BukkitService bukkitService = new BukkitMasterServiceImpl(this, serviceConfig);

        this.services().add(bukkitService);
        return bukkitService;
    }
}
