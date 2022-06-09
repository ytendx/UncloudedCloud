package de.ytendx.mccloud.api.redis;

import org.redisson.api.RedissonClient;

public interface RedisClientProvider {

    RedissonClient client();

}
