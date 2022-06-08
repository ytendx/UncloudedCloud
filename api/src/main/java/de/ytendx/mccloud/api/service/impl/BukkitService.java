package de.ytendx.mccloud.api.service.impl;

import de.ytendx.mccloud.api.service.IServiceGroup;
import de.ytendx.mccloud.api.service.config.IServiceTempConfig;

public abstract class BukkitService extends AbstractService {
    public BukkitService(IServiceGroup<?> parent, IServiceTempConfig config) {
        super(parent, config);
    }
}
