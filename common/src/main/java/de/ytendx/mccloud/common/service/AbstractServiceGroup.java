package de.ytendx.mccloud.common.service;

import de.ytendx.mccloud.api.config.ServiceGroupConfiguration;
import de.ytendx.mccloud.api.service.Service;
import de.ytendx.mccloud.api.service.ServiceGroup;
import de.ytendx.mccloud.api.service.ServiceState;
import de.ytendx.mccloud.api.service.ServiceType;
import de.ytendx.mccloud.api.service.config.ServiceTempConfig;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AbstractServiceGroup<T extends Service> implements ServiceGroup<T> {

    // CONFIG
    private final String name;
    private final String displayName;
    private final int maxPoolMemory;
    private final int maxOnlineServices;
    private final int minOnlineServices;
    private final int maxOnlinePlayers;
    private final boolean staticGroup;
    private final ServiceType serviceType;

    private final String[] preferedRunnerUIDs;

    // RUNNING
    private final List<T> services;

    protected AbstractServiceGroup(String name, String displayName, int maxPoolMemory, int maxOnlineServices, int minOnlineServices, int maxOnlinePlayers, boolean staticGroup, ServiceType serviceType, String[] preferedRunnerUIDs) {
        this.name = name;
        this.displayName = displayName;
        this.maxPoolMemory = maxPoolMemory;
        this.maxOnlineServices = maxOnlineServices;
        this.minOnlineServices = minOnlineServices;
        this.maxOnlinePlayers = maxOnlinePlayers;
        this.staticGroup = staticGroup;
        this.serviceType = serviceType;
        this.preferedRunnerUIDs = preferedRunnerUIDs;
        this.services = new CopyOnWriteArrayList<>();
    }

    protected AbstractServiceGroup(ServiceGroupConfiguration groupModel){
        this.name = groupModel.name();
        this.displayName = groupModel.displayName();
        this.maxPoolMemory = groupModel.maxPoolMemory();
        this.maxOnlineServices = groupModel.maxOnlineServices();
        this.minOnlineServices = groupModel.minOnlineServices();
        this.staticGroup = groupModel.isStatic();
        this.serviceType = groupModel.getType();
        this.maxOnlinePlayers = groupModel.maxPlayers();
        this.preferedRunnerUIDs = groupModel.preferedRunnerUIDs();
        this.services = new CopyOnWriteArrayList<>();
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String displayName() {
        return displayName;
    }

    @Override
    public int maxPoolMemory() {
        return maxPoolMemory;
    }

    @Override
    public int maxOnlineServices() {
        return maxOnlineServices;
    }

    @Override
    public int minOnlineServices() {
        return minOnlineServices;
    }

    @Override
    public int onlineServices() {
        return (int) services().stream().filter(t -> t.state().equals(ServiceState.RUNNING) || t.state().equals(ServiceState.MAINTENANCE)).count();
    }

    @Override
    public boolean isStatic() {
        return staticGroup;
    }

    @Override
    public ServiceType getType() {
        return serviceType;
    }

    @Override
    public String[] preferedRunnerUIDs() {
        return preferedRunnerUIDs;
    }

    @Override
    public List<T> services() {
        return services;
    }

    @Override
    public int maxPlayers() {
        return maxOnlinePlayers;
    }

    @Override
    public abstract Service createService(ServiceTempConfig serviceConfig);
}
