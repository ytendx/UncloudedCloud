package de.ytendx.mccloud.common.management.status;

import de.ytendx.mccloud.management.status.IStatusReport;
import de.ytendx.mccloud.redis.IRedisClientProvider;

public class StatusHandler {

    private final IRedisClientProvider redisClientProvider;

    public StatusHandler(IRedisClientProvider redisClientProvider) {
        this.redisClientProvider = redisClientProvider;

        redisClientProvider.client().getTopic("status").addListener(IStatusReport.class, (channel, msg) -> {

        });
    }
}
