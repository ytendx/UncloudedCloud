package de.ytendx.mccloud.api.redis;

import org.jetbrains.annotations.NotNull;
import org.redisson.api.RedissonClient;

public interface RedisClientProvider {

    @NotNull
    RedissonClient client();

}
