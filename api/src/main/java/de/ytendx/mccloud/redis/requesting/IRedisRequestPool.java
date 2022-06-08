package de.ytendx.mccloud.redis.requesting;

import java.util.function.Consumer;

public interface IRedisRequestPool<Q extends IRedisRequestQuestion, A extends IRedisRequestAnswer> {

    String channel();

    default String requestChannel(){
        return channel() + "_request";
    }

    default String responseChannel(){
        return channel() + "_response";
    }

    void request(Q question, Consumer<A> answerCallback);

}
