package de.ytendx.mccloud.common.redisservice;

import de.ytendx.mccloud.api.management.RunningCloudManagementService;
import de.ytendx.mccloud.api.redis.RedisClientProvider;
import lombok.Getter;
import org.redisson.api.RList;

@Getter
public class ManagementRedisContainer {

    private final RList<RunningCloudManagementService> managementServices;
    private final RedisClientProvider redisClientProvider;

    public ManagementRedisContainer(RedisClientProvider redisClientProvider) {
        this.redisClientProvider = redisClientProvider;
        this.managementServices = redisClientProvider.client().getList("management-services");
    }
}
