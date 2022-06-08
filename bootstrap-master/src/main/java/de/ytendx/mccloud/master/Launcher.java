package de.ytendx.mccloud.master;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import de.ytendx.mccloud.master.configuration.EnviromentalConfigurationValueContainer;
import de.ytendx.mccloud.redis.IRedisClientProvider;
import de.ytendx.mccloud.redis.RedisClientProviderImpl;
import org.redisson.client.codec.Codec;
import org.redisson.codec.JsonJacksonCodec;

public class Launcher {

    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("Launching...");

        EnviromentalConfigurationValueContainer valueContainer = new EnviromentalConfigurationValueContainer();

        IRedisClientProvider redisClientProvider = new RedisClientProviderImpl(new JsonJacksonCodec(JsonMapper.builder().addModule(new JavaTimeModule()).build()),
                valueContainer.getRedisURL(), valueContainer.getRedisPW());

        new RunningMaster(redisClientProvider, valueContainer).start(args);
    }

}
