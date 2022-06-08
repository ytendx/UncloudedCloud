package de.ytendx.mccloud.api.service.impl;

import de.ytendx.mccloud.api.service.IServiceGroup;
import de.ytendx.mccloud.api.service.config.IServiceTempConfig;

public abstract class ProxyService extends AbstractService{
    public ProxyService(IServiceGroup<?> parent, IServiceTempConfig config) {
        super(parent, config);
    }
}
