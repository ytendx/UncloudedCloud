package de.ytendx.mccloud.master.service;

import de.ytendx.mccloud.api.config.ServiceGroupConfiguration;
import de.ytendx.mccloud.api.service.Service;
import de.ytendx.mccloud.api.service.ServiceType;
import de.ytendx.mccloud.api.service.config.ServiceTempConfig;
import de.ytendx.mccloud.api.service.impl.ProxyService;
import de.ytendx.mccloud.common.service.AbstractServiceGroup;

public class ProxyMasterServiceGroupImpl extends AbstractServiceGroup<ProxyService> {
    public ProxyMasterServiceGroupImpl(String name, String displayName, int maxPoolMemory, int maxOnlineServices, int minOnlineServices, int maxOnlinePlayers, boolean staticGroup, String[] preferedRunnerUIDs, ServiceType serviceType) {
        super(name, displayName, maxPoolMemory, maxOnlineServices, minOnlineServices, maxOnlinePlayers, staticGroup, serviceType, preferedRunnerUIDs);
    }

    public ProxyMasterServiceGroupImpl(ServiceGroupConfiguration groupModel) {
        super(groupModel);
    }

    @Override
    public Service createService(ServiceTempConfig serviceConfig) {
        ProxyService proxyService = new ProxyMasterServiceImpl(this, serviceConfig);

        this.services().add(proxyService);
        return proxyService;
    }
}
