package de.ytendx.mccloud.common.redis.requesting;

import de.ytendx.mccloud.api.redis.requesting.RedisRequestAnswer;

import java.util.UUID;

public abstract class AbstractRedisRequestAnswer implements RedisRequestAnswer {

    private final String ID = UUID.randomUUID().toString();

    @Override
    public String id() {
        return ID;
    }
}
