package de.ytendx.mccloud.api.entity;

import de.ytendx.mccloud.api.service.ServiceType;
import jakarta.persistence.*;

@Entity
@Table(name = "service_groups")
public class ServiceGroup {

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

    @Column(name = "static", nullable = false)
    private boolean isStatic;

    @Column(name = "staticRunnerUID", nullable = true)
    private String staticRunnerUID;

    @Column(name = "serviceType", nullable = false)
    private ServiceType serviceType;

}
