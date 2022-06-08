package de.ytendx.mccloud.service;

import de.ytendx.mccloud.service.config.IServiceTempConfig;
import de.ytendx.mccloud.service.servicedatacontainers.ServiceStartDataContainable;
import de.ytendx.mccloud.service.servicedatacontainers.ServiceStopDataContainable;

public interface IService {

    IServiceGroup<?> parent();
    IServiceTempConfig config();

    void start(ServiceStartDataContainable serviceStartDataContainable);
    void stop(ServiceStopDataContainable serviceStopDataContainable);

}
