package de.ytendx.mccloud.runner;

import de.ytendx.mccloud.api.management.impl.RunningRunnerCloudService;
import de.ytendx.mccloud.api.redis.IRedisClientProvider;
import de.ytendx.mccloud.api.running.IRuntimeExecutable;

public class RunningRunner extends RunningRunnerCloudService implements IRuntimeExecutable {
    protected RunningRunner(IRedisClientProvider redisClientProvider) {
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
