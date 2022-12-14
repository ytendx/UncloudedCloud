package de.ytendx.mccloud.api.config;

import de.ytendx.mccloud.api.service.Service;
import de.ytendx.mccloud.api.service.ServiceGroup;
import de.ytendx.mccloud.api.service.ServiceType;
import de.ytendx.mccloud.api.service.config.ServiceTempConfig;

import java.util.List;


// Model for the ServiceGroup Configuration
public class ServiceGroupConfiguration implements ServiceGroup<Service> {

    private String name;

    private String displayName;

    private int maxPoolMemory;

    private int maxOnlineServices;

    private int minOnlineServices;

    /**
     * Counted as "per service"
     */
    private int maxOnlinePlayers;

    /**
     * Counted as "per service"
     */
    private int targetOnlinePlayers;

    private boolean isStatic;

    private String staticRunnerUID;

    private String[] preferedRunnerUIDs;

    private ServiceType serviceType;

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
        throw new UnsupportedOperationException("It is not supported to get the online services through the group model. Please use a group from the redis cache.");
    }

    @Override
    public int maxPlayers() {
        return maxOnlinePlayers;
    }

    public boolean isStatic() {
        return isStatic;
    }

    @Override
    public ServiceType getType() {
        return serviceType;
    }

    @Override
    public List<Service> services() {
        throw new UnsupportedOperationException("It is not supported to list the online services through the group model. Please use a group from the redis cache.");
    }

    @Override
    public String[] preferedRunnerUIDs() {
        return this.preferedRunnerUIDs;
    }

    @Override
    public Service createService(ServiceTempConfig serviceConfig) {
        throw new UnsupportedOperationException("It is not supported to create a service through the group model. Please use a group from the redis cache.");
    }

    public String getStaticRunnerUID() {
        return staticRunnerUID;
    }
}
