package de.ytendx.mccloud.api.management.impl;

import de.ytendx.mccloud.api.management.RunningCloudManagementService;
import de.ytendx.mccloud.api.management.RunningCloudManagementServiceType;
import de.ytendx.mccloud.api.redis.RedisClientProvider;

public abstract class AbstractRunningCloudManagementService implements RunningCloudManagementService {

    private final RunningCloudManagementServiceType runningCloudManagementServiceType;
    private final RedisClientProvider redisClientProvider;

    protected AbstractRunningCloudManagementService(RunningCloudManagementServiceType runningCloudManagementServiceType, RedisClientProvider redisClientProvider) {
        this.runningCloudManagementServiceType = runningCloudManagementServiceType;
        this.redisClientProvider = redisClientProvider;
    }

    @Override
    public RunningCloudManagementServiceType type() {
        return this.runningCloudManagementServiceType;
    }

    @Override
    public RedisClientProvider getRedissonClientProvider() {
        return this.redisClientProvider;
    }
}
