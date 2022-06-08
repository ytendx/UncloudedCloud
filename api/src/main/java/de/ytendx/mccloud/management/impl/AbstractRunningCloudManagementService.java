package de.ytendx.mccloud.management.impl;

import de.ytendx.mccloud.management.IRunningCloudManagementService;
import de.ytendx.mccloud.management.RunningCloudManagementServiceType;
import de.ytendx.mccloud.redis.IRedisClientProvider;

public abstract class AbstractRunningCloudManagementService implements IRunningCloudManagementService {

    private final RunningCloudManagementServiceType runningCloudManagementServiceType;
    private final IRedisClientProvider redisClientProvider;

    protected AbstractRunningCloudManagementService(RunningCloudManagementServiceType runningCloudManagementServiceType, IRedisClientProvider redisClientProvider) {
        this.runningCloudManagementServiceType = runningCloudManagementServiceType;
        this.redisClientProvider = redisClientProvider;
    }

    @Override
    public RunningCloudManagementServiceType type() {
        return this.runningCloudManagementServiceType;
    }

    @Override
    public IRedisClientProvider getRedissonClientProvider() {
        return this.redisClientProvider;
    }
}
