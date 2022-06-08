package de.ytendx.mccloud.api.service.impl;

import de.ytendx.mccloud.api.service.IService;
import de.ytendx.mccloud.api.service.IServiceGroup;
import de.ytendx.mccloud.api.service.config.IServiceTempConfig;
import de.ytendx.mccloud.api.service.servicedatacontainers.ServiceStartDataContainable;
import de.ytendx.mccloud.api.service.servicedatacontainers.ServiceStopDataContainable;

public abstract class AbstractService implements IService {

    private final IServiceGroup<?> parent;
    private final IServiceTempConfig config;

    public AbstractService(IServiceGroup<?> parent, IServiceTempConfig config) {
        this.parent = parent;
        this.config = config;
    }

    @Override
    public IServiceGroup<?> parent() {
        return parent;
    }

    @Override
    public IServiceTempConfig config() {
        return config;
    }

    @Override
    public abstract void start(ServiceStartDataContainable serviceStartDataContainable);

    @Override
    public abstract void stop(ServiceStopDataContainable serviceStopDataContainable);
}
