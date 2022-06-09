package de.ytendx.mccloud.api.management.impl;

import de.ytendx.mccloud.api.management.RunningCloudManagementServiceType;
import de.ytendx.mccloud.api.redis.RedisClientProvider;

public abstract class RunningMasterCloudService extends AbstractRunningCloudManagementService {
    protected RunningMasterCloudService(RedisClientProvider redisClientProvider) {
        super(RunningCloudManagementServiceType.MASTER, redisClientProvider);
    }
}
