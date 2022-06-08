package de.ytendx.mccloud.service;

import de.ytendx.mccloud.service.config.IServiceTempConfig;

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
