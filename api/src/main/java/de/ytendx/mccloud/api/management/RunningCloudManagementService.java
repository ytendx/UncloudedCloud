package de.ytendx.mccloud.api.management;

import de.ytendx.mccloud.api.redis.RedisClientProvider;

public interface RunningCloudManagementService {

    RedisClientProvider getRedissonClientProvider();
    RunningCloudManagementServiceType type();
    String uid();
    void tick();

}
