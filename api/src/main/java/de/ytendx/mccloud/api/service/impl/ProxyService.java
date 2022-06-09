package de.ytendx.mccloud.api.service.impl;

import de.ytendx.mccloud.api.service.ServiceGroup;
import de.ytendx.mccloud.api.service.config.ServiceTempConfig;

public abstract class ProxyService extends AbstractService{
    public ProxyService(ServiceGroup<?> parent, ServiceTempConfig config) {
        super(parent, config);
    }
}
