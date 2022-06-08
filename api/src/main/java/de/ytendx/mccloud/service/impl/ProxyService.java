package de.ytendx.mccloud.service.impl;

import de.ytendx.mccloud.service.IServiceGroup;
import de.ytendx.mccloud.service.config.IServiceTempConfig;

public abstract class ProxyService extends AbstractService{
    public ProxyService(IServiceGroup<?> parent, IServiceTempConfig config) {
        super(parent, config);
    }
}
