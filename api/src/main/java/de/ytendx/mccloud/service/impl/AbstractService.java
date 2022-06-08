package de.ytendx.mccloud.service.impl;

import de.ytendx.mccloud.service.IService;
import de.ytendx.mccloud.service.IServiceGroup;
import de.ytendx.mccloud.service.config.IServiceTempConfig;
import de.ytendx.mccloud.service.servicedatacontainers.ServiceStartDataContainable;
import de.ytendx.mccloud.service.servicedatacontainers.ServiceStopDataContainable;

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
