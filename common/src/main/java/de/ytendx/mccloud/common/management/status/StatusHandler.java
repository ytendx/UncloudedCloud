package de.ytendx.mccloud.common.management.status;

import de.ytendx.mccloud.api.redis.IRedisClientProvider;
import de.ytendx.mccloud.management.status.IStatusReport;

public class StatusHandler {

    private final IRedisClientProvider redisClientProvider;

    public StatusHandler(IRedisClientProvider redisClientProvider) {
        this.redisClientProvider = redisClientProvider;

        redisClientProvider.client().getTopic("status").addListener(IStatusReport.class, (channel, msg) -> {

        });
    }
}
