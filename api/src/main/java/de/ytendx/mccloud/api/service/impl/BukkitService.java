package de.ytendx.mccloud.api.service.impl;

import de.ytendx.mccloud.api.service.config.IServiceTempConfig;
import de.ytendx.mccloud.api.service.IServiceGroup;

public abstract class BukkitService extends AbstractService {
    public BukkitService(IServiceGroup<?> parent, IServiceTempConfig config) {
        super(parent, config);
    }
}
