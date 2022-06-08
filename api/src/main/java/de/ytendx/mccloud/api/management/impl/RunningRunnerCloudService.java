package de.ytendx.mccloud.api.management.impl;

import de.ytendx.mccloud.api.management.RunningCloudManagementServiceType;
import de.ytendx.mccloud.api.redis.IRedisClientProvider;

public abstract class RunningRunnerCloudService extends AbstractRunningCloudManagementService{
    protected RunningRunnerCloudService(IRedisClientProvider redisClientProvider) {
        super(RunningCloudManagementServiceType.RUNNER, redisClientProvider);
    }
}
