package de.ytendx.mccloud.common.redisservice.requesting.service;

import de.ytendx.mccloud.api.redis.requesting.status.RedisRequestStatus;
import de.ytendx.mccloud.common.redis.requesting.AbstractRedisRequestAnswer;

public class ServiceStartRequestAnswer extends AbstractRedisRequestAnswer {

    private final RedisRequestStatus requestStatus;

    public ServiceStartRequestAnswer(RedisRequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    @Override
    public RedisRequestStatus status() {
        return requestStatus;
    }
}
