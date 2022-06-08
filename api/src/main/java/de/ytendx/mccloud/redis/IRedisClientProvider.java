package de.ytendx.mccloud.redis;

import org.redisson.api.RedissonClient;

public interface IRedisClientProvider {

    RedissonClient client();

}
