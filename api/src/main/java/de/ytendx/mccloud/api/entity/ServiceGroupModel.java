package de.ytendx.mccloud.api.entity;

import de.ytendx.mccloud.api.service.Service;
import de.ytendx.mccloud.api.service.ServiceGroup;
import de.ytendx.mccloud.api.service.ServiceType;
import de.ytendx.mccloud.api.service.config.ServiceTempConfig;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "service_groups")
public class ServiceGroupModel implements ServiceGroup<Service> {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "displayName", nullable = false)
    private String displayName;

    @Column(name = "maxPoolMemory", nullable = false)
    private int maxPoolMemory;

    @Column(name = "maxOnlineServices", nullable = false)
    private int maxOnlineServices;

    @Column(name = "minOnlineServices", nullable = false)
    private int minOnlineServices;

    @Column(name = "minOnlineServices", nullable = false)
    private int maxOnlinePlayers;

    @Column(name = "static", nullable = false)
    private boolean isStatic;

    @Column(name = "staticRunnerUID", nullable = true)
    private String staticRunnerUID;

    @Column(name = "serviceType", nullable = false)
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
        return -1;
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
        return null;
    }

    @Override
    public void createService(ServiceTempConfig serviceConfig) {
    }

    public String getStaticRunnerUID() {
        return staticRunnerUID;
    }
}
