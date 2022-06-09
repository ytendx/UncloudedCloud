package de.ytendx.mccloud.master;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import de.ytendx.mccloud.api.database.DatabaseProvider;
import de.ytendx.mccloud.api.entity.ServiceGroup;
import de.ytendx.mccloud.api.redis.RedisClientProvider;
import de.ytendx.mccloud.api.redis.RedisClientProviderImpl;
import de.ytendx.mccloud.common.database.DatabaseProviderImpl;
import de.ytendx.mccloud.common.configuration.EnviromentalConfigurationValueContainer;
import org.redisson.codec.JsonJacksonCodec;

public final class Launcher {

    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("Launching ...");

        EnviromentalConfigurationValueContainer valueContainer = new EnviromentalConfigurationValueContainer();

        RedisClientProvider redisClientProvider = new RedisClientProviderImpl(
                new JsonJacksonCodec(JsonMapper.builder().addModule(new JavaTimeModule()).build()),
                valueContainer.getRedisURL(), valueContainer.getRedisPW()
        );

        DatabaseProvider databaseProvider = new DatabaseProviderImpl(
                System.getenv("DB_URL"),
                System.getenv("DB_USER"),
                System.getenv("DB_PASS"),
                Integer.parseInt(System.getenv("DB_MIN_IDLE")),
                Integer.parseInt(System.getenv("DB_MAX_CONN"))
        );
        databaseProvider.addEntity(ServiceGroup.class);

        new RunningMaster(redisClientProvider, databaseProvider.getSessionFactory(), valueContainer).start(args);
    }
}
