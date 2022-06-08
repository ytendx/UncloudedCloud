package de.ytendx.mccloud.redis.requesting;

import de.ytendx.mccloud.redis.requesting.status.RedisRequestStatus;

public interface IRedisRequestAnswer {

    RedisRequestStatus status();

}
