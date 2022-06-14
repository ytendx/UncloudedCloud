package de.ytendx.mccloud.master.service;

import de.ytendx.mccloud.api.service.ServiceGroup;
import de.ytendx.mccloud.api.service.ServiceState;
import de.ytendx.mccloud.api.service.config.ServiceTempConfig;
import de.ytendx.mccloud.api.service.impl.AbstractService;
import de.ytendx.mccloud.api.service.impl.ProxyService;
import de.ytendx.mccloud.api.service.servicedatacontainers.ServiceStartDataContainable;
import de.ytendx.mccloud.api.service.servicedatacontainers.ServiceStopDataContainable;

public class ProxyMasterServiceImpl extends ProxyService {

    private final ServiceState serviceState;

    public ProxyMasterServiceImpl(ServiceGroup<?> parent, ServiceTempConfig config) {
        super(parent, config);
        this.serviceState = ServiceState.STARTING;
    }

    @Override
    public ServiceState state() {
        return serviceState;
    }

    @Override
    public void start(ServiceStartDataContainable serviceStartDataContainable) {

    }

    @Override
    public void stop(ServiceStopDataContainable serviceStopDataContainable) {

    }
}
