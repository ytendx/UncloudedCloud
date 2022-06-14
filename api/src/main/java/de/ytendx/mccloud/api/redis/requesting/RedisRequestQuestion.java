package de.ytendx.mccloud.api.redis.requesting;

public interface RedisRequestQuestion {

    String id();

    default String desc(){
        return "Unclouded Cloud Redis Question";
    }

}
