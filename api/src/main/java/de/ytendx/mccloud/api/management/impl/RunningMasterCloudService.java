package de.ytendx.mccloud.api.management.impl;

import de.ytendx.mccloud.api.management.RunningCloudManagementServiceType;
import de.ytendx.mccloud.api.redis.IRedisClientProvider;

public abstract class RunningMasterCloudService extends AbstractRunningCloudManagementService {
    protected RunningMasterCloudService(IRedisClientProvider redisClientProvider) {
        super(RunningCloudManagementServiceType.MASTER, redisClientProvider);
    }
}
