package de.ytendx.mccloud.api.management;

import de.ytendx.mccloud.api.redis.IRedisClientProvider;

public interface IRunningCloudManagementService {

    IRedisClientProvider getRedissonClientProvider();
    RunningCloudManagementServiceType type();
    String uid();
    void tick();

}
