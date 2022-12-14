package de.ytendx.mccloud.api.redis.requesting;

public interface RedisRequestPoolChannelContainable {

    String channel();

    default String requestChannel(){
        return channel() + "_request";
    }

    default String responseChannel(){
        return channel() + "_response";
    }


}
