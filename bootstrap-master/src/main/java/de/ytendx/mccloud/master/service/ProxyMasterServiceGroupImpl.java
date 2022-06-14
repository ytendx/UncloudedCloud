package de.ytendx.mccloud.master.service;

import de.ytendx.mccloud.api.entity.ServiceGroupModel;
import de.ytendx.mccloud.api.service.ServiceType;
import de.ytendx.mccloud.api.service.config.ServiceTempConfig;
import de.ytendx.mccloud.api.service.impl.ProxyService;
import de.ytendx.mccloud.common.service.AbstractServiceGroup;

public class ProxyMasterServiceGroupImpl extends AbstractServiceGroup<ProxyService> {
    public ProxyMasterServiceGroupImpl(String name, String displayName, int maxPoolMemory, int maxOnlineServices, int minOnlineServices, int maxOnlinePlayers, boolean staticGroup, ServiceType serviceType) {
        super(name, displayName, maxPoolMemory, maxOnlineServices, minOnlineServices, maxOnlinePlayers, staticGroup, serviceType);
    }

    public ProxyMasterServiceGroupImpl(ServiceGroupModel groupModel) {
        super(groupModel);
    }

    @Override
    public void createService(ServiceTempConfig serviceConfig) {
        ProxyService proxyService = new ProxyMasterServiceImpl(this, serviceConfig);

        this.services().add(proxyService);
    }
}
