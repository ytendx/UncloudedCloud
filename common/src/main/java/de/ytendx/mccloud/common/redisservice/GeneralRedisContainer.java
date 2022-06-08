package de.ytendx.mccloud.common.redisservice;

import de.ytendx.mccloud.api.redis.IRedisClientProvider;
import de.ytendx.mccloud.api.service.IServiceGroup;
import de.ytendx.mccloud.api.service.impl.BukkitService;
import de.ytendx.mccloud.api.service.impl.ProxyService;
import lombok.Getter;
import org.redisson.api.RList;

@Getter
public class GeneralRedisContainer {

    private final IRedisClientProvider iRedisClientProvider;
    private final RList<IServiceGroup<BukkitService>> bukkitServices;
    private final RList<IServiceGroup<ProxyService>> proxyServices;


    public GeneralRedisContainer(IRedisClientProvider iRedisClientProvider) {
        this.iRedisClientProvider = iRedisClientProvider;
        this.bukkitServices = iRedisClientProvider.client().getList("bukkit-services");
        this.proxyServices = iRedisClientProvider.client().getList("proxy-services");
    }

    public IRedisClientProvider getiRedisClientProvider() {
        return iRedisClientProvider;
    }

    public RList<IServiceGroup<BukkitService>> getBukkitServices() {
        return bukkitServices;
    }

    public RList<IServiceGroup<ProxyService>> getProxyServices() {
        return proxyServices;
    }
}
