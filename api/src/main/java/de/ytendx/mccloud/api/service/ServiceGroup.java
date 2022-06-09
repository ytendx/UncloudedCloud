package de.ytendx.mccloud.api.service;

import de.ytendx.mccloud.api.service.config.ServiceTempConfig;

import java.util.List;

public interface ServiceGroup<T extends Service> {

    String name();
    String displayName();

    int maxPoolMemory();
    int maxOnlineServices();
    int minOnlineServices();

    boolean isStatic();
    Class<? extends Service> getType();

    List<T> services();

    void createService(ServiceTempConfig serviceConfig);

}