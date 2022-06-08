package de.ytendx.mccloud.api.service;

import de.ytendx.mccloud.api.service.config.IServiceTempConfig;

import java.util.List;

public interface IServiceGroup<T extends IService> {

    String name();
    String displayName();

    int maxPoolMemory();
    int maxOnlineServices();
    int minOnlineServices();

    boolean isStatic();
    Class<? extends IService> getType();

    List<T> services();

    void createService(IServiceTempConfig serviceConfig);

}
