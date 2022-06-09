package de.ytendx.mccloud.common.management.status;

import de.ytendx.mccloud.api.redis.RedisClientProvider;
import de.ytendx.mccloud.api.management.status.StatusReport;

public class StatusHandler {

    private final RedisClientProvider redisClientProvider;

    public StatusHandler(RedisClientProvider redisClientProvider) {
        this.redisClientProvider = redisClientProvider;

        redisClientProvider.client().getTopic("status").addListener(StatusReport.class, (channel, msg) -> {

        });
    }
}
