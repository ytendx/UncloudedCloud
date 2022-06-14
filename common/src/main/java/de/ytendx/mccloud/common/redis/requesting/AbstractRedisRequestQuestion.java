package de.ytendx.mccloud.common.redis.requesting;

import de.ytendx.mccloud.api.redis.requesting.RedisRequestQuestion;

import java.util.UUID;

public abstract class AbstractRedisRequestQuestion implements RedisRequestQuestion {

    private final String ID = UUID.randomUUID().toString();

    @Override
    public String id() {
        return ID;
    }
}
