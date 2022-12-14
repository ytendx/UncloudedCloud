package de.ytendx.mccloud.api.redis.requesting;

import java.util.function.Consumer;

public interface RedisRequestPool<Q extends RedisRequestQuestion, A extends RedisRequestAnswer> {

    void request(Q question, Consumer<A> answerCallback);

}
