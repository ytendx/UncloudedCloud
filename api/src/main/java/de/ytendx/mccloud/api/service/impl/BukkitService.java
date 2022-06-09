package de.ytendx.mccloud.api.service.impl;

import de.ytendx.mccloud.api.service.ServiceGroup;
import de.ytendx.mccloud.api.service.config.ServiceTempConfig;

public abstract class BukkitService extends AbstractService {
    public BukkitService(ServiceGroup<?> parent, ServiceTempConfig config) {
        super(parent, config);
    }
}
