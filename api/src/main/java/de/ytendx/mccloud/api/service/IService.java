package de.ytendx.mccloud.api.service;

import de.ytendx.mccloud.api.service.config.IServiceTempConfig;
import de.ytendx.mccloud.api.service.servicedatacontainers.ServiceStartDataContainable;
import de.ytendx.mccloud.api.service.servicedatacontainers.ServiceStopDataContainable;

public interface IService {

    IServiceGroup<?> parent();
    IServiceTempConfig config();

    void start(ServiceStartDataContainable serviceStartDataContainable);
    void stop(ServiceStopDataContainable serviceStopDataContainable);

}
