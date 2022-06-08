package de.ytendx.mccloud.common.redisservice;

import de.ytendx.mccloud.management.IRunningCloudManagementService;
import de.ytendx.mccloud.redis.IRedisClientProvider;
import lombok.Getter;
import org.redisson.api.RList;

@Getter
public class ManagementRedisContainer {

    private final RList<IRunningCloudManagementService> managementServices;
    private final IRedisClientProvider redisClientProvider;

    public ManagementRedisContainer(IRedisClientProvider redisClientProvider) {
        this.redisClientProvider = redisClientProvider;
        this.managementServices = redisClientProvider.client().getList("management-services");
    }
}
