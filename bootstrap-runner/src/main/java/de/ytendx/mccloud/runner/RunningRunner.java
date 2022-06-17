package de.ytendx.mccloud.runner;

import de.ytendx.mccloud.api.management.impl.RunningRunnerCloudService;
import de.ytendx.mccloud.api.redis.RedisClientProvider;
import de.ytendx.mccloud.api.running.RuntimeExecutable;
import de.ytendx.mccloud.common.redisservice.GeneralRedisContainer;
import de.ytendx.mccloud.common.redisservice.ManagementRedisContainer;

public class RunningRunner extends RunningRunnerCloudService implements RuntimeExecutable {

    private final GeneralRedisContainer generalRedisContainer;
    private final ManagementRedisContainer managementRedisContainer;

    protected RunningRunner(RedisClientProvider redisClientProvider) {
        super(redisClientProvider);
        generalRedisContainer = new GeneralRedisContainer(redisClientProvider);
        managementRedisContainer = new ManagementRedisContainer(redisClientProvider);
    }

    @Override
    public String uid() {
        return System.getenv("RUNNER_UID");
    }

    @Override
    public void tick() {

    }

    @Override
    public void start(String[] args) {

    }

    @Override
    public void stop(String reason) {

    }
}
