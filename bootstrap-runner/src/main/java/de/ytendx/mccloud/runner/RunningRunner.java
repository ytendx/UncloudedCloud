package de.ytendx.mccloud.runner;

import de.ytendx.mccloud.api.management.impl.RunningRunnerCloudService;
import de.ytendx.mccloud.api.redis.RedisClientProvider;
import de.ytendx.mccloud.api.running.RuntimeExecutable;

public class RunningRunner extends RunningRunnerCloudService implements RuntimeExecutable {
    protected RunningRunner(RedisClientProvider redisClientProvider) {
        super(redisClientProvider);
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
