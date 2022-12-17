package de.ytendx.mccloud.master;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import de.ytendx.mccloud.api.redis.RedisClientProvider;
import de.ytendx.mccloud.common.redis.RedisClientProviderImpl;
import de.ytendx.mccloud.master.configuration.MasterEnvVariableValueContainer;
import org.redisson.codec.JsonJacksonCodec;

public final class Launcher {

    public static final String VERSION = "0.1.1-DEVELOPMENT";

    public static void main(String[] args) throws IllegalAccessException {
        System.out.printf("Launching Unclouded Cloud v%s....%n", VERSION);

        MasterEnvVariableValueContainer valueContainer = new MasterEnvVariableValueContainer();

        RedisClientProvider redisClientProvider = new RedisClientProviderImpl(
                new JsonJacksonCodec(JsonMapper.builder().addModule(new JavaTimeModule()).build()),
                valueContainer.getRedisURL(), valueContainer.getRedisPW()
        );

        new RunningMaster(redisClientProvider, valueContainer).start(args);
    }
}
