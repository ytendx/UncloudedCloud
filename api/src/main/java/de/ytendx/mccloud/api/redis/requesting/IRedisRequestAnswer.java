package de.ytendx.mccloud.api.redis.requesting;

import de.ytendx.mccloud.api.redis.requesting.status.RedisRequestStatus;

public interface IRedisRequestAnswer {

    RedisRequestStatus status();

}
