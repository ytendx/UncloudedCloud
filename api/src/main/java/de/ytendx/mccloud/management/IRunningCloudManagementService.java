package de.ytendx.mccloud.management;

import de.ytendx.mccloud.redis.IRedisClientProvider;

public interface IRunningCloudManagementService {

    IRedisClientProvider getRedissonClientProvider();
    RunningCloudManagementServiceType type();
    String uid();
    void tick();

}
