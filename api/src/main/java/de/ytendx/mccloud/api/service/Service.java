package de.ytendx.mccloud.api.service;

import de.ytendx.mccloud.api.service.config.ServiceTempConfig;
import de.ytendx.mccloud.api.service.servicedatacontainers.ServiceStartDataContainable;
import de.ytendx.mccloud.api.service.servicedatacontainers.ServiceStopDataContainable;

public interface Service {

    ServiceGroup<?> parent();
    ServiceTempConfig config();

    void start(ServiceStartDataContainable serviceStartDataContainable);
    void stop(ServiceStopDataContainable serviceStopDataContainable);

}
