package de.ytendx.mccloud.common.service;

import de.ytendx.mccloud.api.service.config.ServiceTempConfig;

public class ServiceTempConfigImpl implements ServiceTempConfig {

    private final int maxPlayers, maxMemory;
    private final String name, displayName;

    public ServiceTempConfigImpl(int maxPlayers, int maxMemory, String name, String displayName) {
        this.maxPlayers = maxPlayers;
        this.maxMemory = maxMemory;
        this.name = name;
        this.displayName = displayName;
    }

    @Override
    public int maxPlayers() {
        return maxPlayers;
    }

    @Override
    public int maxMemory() {
        return maxMemory;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String displayName() {
        return displayName;
    }
}
