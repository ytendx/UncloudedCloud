package de.ytendx.mccloud.api.service;

import de.ytendx.mccloud.api.service.config.ServiceTempConfig;

import java.util.List;

public interface ServiceGroup<T extends Service> {

    String name();
    String displayName();

    int maxPoolMemory();

    int maxOnlineServices();
    int minOnlineServices();

    int onlineServices();
    int maxPlayers();

    boolean isStatic();
    ServiceType getType();

    List<T> services();

    String[] preferedRunnerUIDs();

    Service createService(ServiceTempConfig serviceConfig);

}
