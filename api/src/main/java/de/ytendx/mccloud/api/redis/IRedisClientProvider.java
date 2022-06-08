package de.ytendx.mccloud.api.redis;

import org.redisson.api.RedissonClient;

public interface IRedisClientProvider {

    RedissonClient client();

}
