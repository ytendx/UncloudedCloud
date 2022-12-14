package de.ytendx.mccloud.runner.management;

import de.ytendx.mccloud.api.redis.RedisClientProvider;
import de.ytendx.mccloud.common.redis.requesting.RedisRequestPoolHandlerImpl;
import de.ytendx.mccloud.common.redisservice.requesting.service.ServiceStartRequestAnswer;
import de.ytendx.mccloud.common.redisservice.requesting.service.ServiceStartRequestQuestion;

public class RedisServiceWorker {

    public RedisServiceWorker(RedisClientProvider redisClientProvider) {

        // TODO
//        new RedisRequestPoolHandlerImpl<ServiceStartRequestQuestion, ServiceStartRequestAnswer>(
//                redisClientProvider,
//                ""
//        )

    }
}
