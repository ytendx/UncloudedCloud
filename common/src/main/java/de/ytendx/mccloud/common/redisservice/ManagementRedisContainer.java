package de.ytendx.mccloud.common.redisservice;

import de.ytendx.mccloud.api.management.RunningCloudManagementService;
import de.ytendx.mccloud.api.redis.RedisClientProvider;
import lombok.Getter;
import org.redisson.api.RList;
import org.redisson.api.RMap;
import org.redisson.api.RMapCache;

@Getter
public class ManagementRedisContainer {

    private final RMapCache<String, RunningCloudManagementService> managementServices;
    private final RedisClientProvider redisClientProvider;

    public ManagementRedisContainer(RedisClientProvider redisClientProvider) {
        this.redisClientProvider = redisClientProvider;
        this.managementServices = redisClientProvider.client().getMapCache("management-services");
    }
}
