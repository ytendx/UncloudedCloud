package de.ytendx.mccloud.api.management.impl;

import de.ytendx.mccloud.api.management.RunningCloudManagementServiceType;
import de.ytendx.mccloud.api.redis.RedisClientProvider;

public abstract class RunningRunnerCloudService extends AbstractRunningCloudManagementService{
    protected RunningRunnerCloudService(RedisClientProvider redisClientProvider) {
        super(RunningCloudManagementServiceType.RUNNER, redisClientProvider);
    }
}
