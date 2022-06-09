package de.ytendx.mccloud.api.redis.requesting;

import java.util.function.Consumer;

public interface RedisRequestPool<Q extends RedisRequestQuestion, A extends RedisRequestAnswer> {

    String channel();

    default String requestChannel(){
        return channel() + "_request";
    }

    default String responseChannel(){
        return channel() + "_response";
    }

    void request(Q question, Consumer<A> answerCallback);

}
