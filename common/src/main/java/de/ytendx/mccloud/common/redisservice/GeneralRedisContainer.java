package de.ytendx.mccloud.common.redisservice;

import de.ytendx.mccloud.api.redis.RedisClientProvider;
import de.ytendx.mccloud.api.service.ServiceGroup;
import de.ytendx.mccloud.api.service.impl.BukkitService;
import de.ytendx.mccloud.api.service.impl.ProxyService;
import lombok.Getter;
import org.redisson.api.RList;

@Getter
public class GeneralRedisContainer {

    private final RedisClientProvider iRedisClientProvider;
    private final RList<ServiceGroup<BukkitService>> bukkitServices;
    private final RList<ServiceGroup<ProxyService>> proxyServices;


    public GeneralRedisContainer(RedisClientProvider iRedisClientProvider) {
        this.iRedisClientProvider = iRedisClientProvider;
        this.bukkitServices = iRedisClientProvider.client().getList("bukkit-services");
        this.proxyServices = iRedisClientProvider.client().getList("proxy-services");
    }

    public RedisClientProvider getiRedisClientProvider() {
        return iRedisClientProvider;
    }

    public RList<ServiceGroup<BukkitService>> getBukkitServices() {
        return bukkitServices;
    }

    public RList<ServiceGroup<ProxyService>> getProxyServices() {
        return proxyServices;
    }
}
