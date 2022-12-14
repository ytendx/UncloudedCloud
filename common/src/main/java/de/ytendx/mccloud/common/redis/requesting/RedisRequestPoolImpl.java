package de.ytendx.mccloud.common.redis.requesting;

import de.ytendx.mccloud.api.redis.RedisClientProvider;
import de.ytendx.mccloud.api.redis.requesting.RedisRequestAnswer;
import de.ytendx.mccloud.api.redis.requesting.RedisRequestPool;
import de.ytendx.mccloud.api.redis.requesting.RedisRequestPoolChannelContainable;
import de.ytendx.mccloud.api.redis.requesting.RedisRequestQuestion;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class RedisRequestPoolImpl<Q extends RedisRequestQuestion, A extends RedisRequestAnswer> implements RedisRequestPool<Q, A>, RedisRequestPoolChannelContainable {

    private final String channel;
    private final RedisClientProvider redisClientProvider;

    private final Map<String, Consumer<A>> pool;

    public RedisRequestPoolImpl(RedisClientProvider redisClientProvider, String channel, Class<? extends RedisRequestAnswer> answerClass) {
        this.redisClientProvider = redisClientProvider;
        this.channel = channel;
        this.pool = new ConcurrentHashMap<>();

        this.redisClientProvider.client().getTopic(responseChannel()).addListener(answerClass, (channel1, msg) -> {
            pool.get(msg.id()).accept((A) msg); // Improve that???
            pool.remove(msg.id());
        });
    }

    @Override
    public String channel() {
        return channel;
    }

    @Override
    public void request(Q question, Consumer<A> answerCallback) {
        pool.put(question.id(), answerCallback);

        this.redisClientProvider.client().getTopic(requestChannel()).publish(question);
    }
}
