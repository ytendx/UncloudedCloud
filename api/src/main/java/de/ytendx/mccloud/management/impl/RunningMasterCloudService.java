package de.ytendx.mccloud.management.impl;

import de.ytendx.mccloud.management.RunningCloudManagementServiceType;
import de.ytendx.mccloud.redis.IRedisClientProvider;

public abstract class RunningMasterCloudService extends AbstractRunningCloudManagementService {
    protected RunningMasterCloudService(IRedisClientProvider redisClientProvider) {
        super(RunningCloudManagementServiceType.MASTER, redisClientProvider);
    }
}
