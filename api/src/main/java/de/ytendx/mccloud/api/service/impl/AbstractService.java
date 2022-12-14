package de.ytendx.mccloud.api.service.impl;

import de.ytendx.mccloud.api.service.Service;
import de.ytendx.mccloud.api.service.ServiceGroup;
import de.ytendx.mccloud.api.service.config.ServiceTempConfig;
import de.ytendx.mccloud.api.service.servicedatacontainers.ServiceStartDataContainable;
import de.ytendx.mccloud.api.service.servicedatacontainers.ServiceStopDataContainable;

import java.util.UUID;

public abstract class AbstractService implements Service {

    private final String id;
    private final ServiceGroup<?> parent;
    private final ServiceTempConfig config;

    public AbstractService(ServiceGroup<?> parent, ServiceTempConfig config) {
        this.parent = parent;
        this.config = config;

        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public ServiceGroup<?> parent() {
        return parent;
    }

    @Override
    public ServiceTempConfig config() {
        return config;
    }

    @Override
    public abstract void start(ServiceStartDataContainable serviceStartDataContainable);

    @Override
    public abstract void stop(ServiceStopDataContainable serviceStopDataContainable);
}
