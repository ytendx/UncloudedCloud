package de.ytendx.mccloud.common.redis.requesting;

import de.ytendx.mccloud.api.redis.RedisClientProvider;
import de.ytendx.mccloud.api.redis.requesting.RedisRequestAnswer;
import de.ytendx.mccloud.api.redis.requesting.RedisRequestPoolChannelContainable;
import de.ytendx.mccloud.api.redis.requesting.RedisRequestQuestion;
import de.ytendx.mccloud.api.redis.requesting.handle.RedisRequestHandler;

import java.util.function.Consumer;

public class RedisRequestPoolHandlerImpl<Q extends RedisRequestQuestion, A extends RedisRequestAnswer> implements RedisRequestHandler<Q, A>, RedisRequestPoolChannelContainable {

    private final String channel;

    public RedisRequestPoolHandlerImpl(RedisClientProvider redisClientProvider, String channel, Class<? extends RedisRequestQuestion> questionClass, Consumer<Q> answer) {
        this.channel = channel;

        redisClientProvider.client().getTopic(requestChannel()).addListener(questionClass, (channel1, msg) -> answer.accept((Q) msg));


    }

    @Override
    public String channel() {
        return channel;
    }
}
