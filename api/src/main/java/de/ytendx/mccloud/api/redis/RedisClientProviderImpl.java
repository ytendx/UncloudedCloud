package de.ytendx.mccloud.api.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.Codec;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;

public class RedisClientProviderImpl implements IRedisClientProvider {

    private final RedissonClient redissonClient;

    public RedisClientProviderImpl(Codec codec, String address, String password) {
        Config config = new Config();

        config.setCodec(codec);
        config.setTransportMode(TransportMode.NIO); // maybe later change that to epoll?
        config.useSingleServer()
                .setConnectTimeout(4000)
                .setRetryInterval(2000)
                .setRetryAttempts(10)
                .setAddress(address)
                .setPassword(password);

        redissonClient = Redisson.create(config);
    }

    @Override
    public RedissonClient client() {
        return this.redissonClient;
    }
}
