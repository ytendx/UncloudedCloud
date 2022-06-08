package de.ytendx.mccloud.management.impl;

import de.ytendx.mccloud.management.RunningCloudManagementServiceType;
import de.ytendx.mccloud.redis.IRedisClientProvider;

public abstract class RunningRunnerCloudService extends AbstractRunningCloudManagementService{
    protected RunningRunnerCloudService(IRedisClientProvider redisClientProvider) {
        super(RunningCloudManagementServiceType.RUNNER, redisClientProvider);
    }
}
