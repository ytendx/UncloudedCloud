package de.ytendx.mccloud.common.redisservice;

import de.ytendx.mccloud.api.redis.RedisClientProvider;
import de.ytendx.mccloud.api.service.ServiceGroup;
import de.ytendx.mccloud.api.service.impl.BukkitService;
import de.ytendx.mccloud.api.service.impl.ProxyService;
import lombok.Getter;
import org.redisson.api.RMap;

@Getter
public class GeneralRedisContainer {

    private final RedisClientProvider iRedisClientProvider;
    private final RMap<String, ServiceGroup<BukkitService>> bukkitServices;
    private final RMap<String, ServiceGroup<ProxyService>> proxyServices;


    public GeneralRedisContainer(RedisClientProvider iRedisClientProvider) {
        this.iRedisClientProvider = iRedisClientProvider;
        this.bukkitServices = iRedisClientProvider.client().getMap("bukkit-services");
        this.proxyServices = iRedisClientProvider.client().getMap("proxy-services");
    }

    public RedisClientProvider getiRedisClientProvider() {
        return iRedisClientProvider;
    }

    public RMap<String, ServiceGroup<BukkitService>> getBukkitServices() {
        return bukkitServices;
    }

    public RMap<String, ServiceGroup<ProxyService>> getProxyServices() {
        return proxyServices;
    }
}
