package de.ytendx.mccloud.common.redisservice.requesting.service;

import de.ytendx.mccloud.api.redis.RedisClientProvider;
import de.ytendx.mccloud.common.redis.requesting.RedisRequestPoolImpl;

public class ServiceStartRequestPool extends RedisRequestPoolImpl<ServiceStartRequestQuestion, ServiceStartRequestAnswer> {
    public ServiceStartRequestPool(RedisClientProvider redisClientProvider, String runnerUID) {
        super(redisClientProvider, "service-start_" + runnerUID, ServiceStartRequestAnswer.class);
    }
}
