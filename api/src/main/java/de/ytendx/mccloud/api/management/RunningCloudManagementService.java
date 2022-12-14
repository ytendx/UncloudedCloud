package de.ytendx.mccloud.api.management;

import de.ytendx.mccloud.api.redis.RedisClientProvider;

/**
 * A RunningCloudManagementService is a running instance of a premised cloud management
 * program e.g. the Runner or Manager. A RunningCloudManagementService always contains a unique
 * id which depends on the environment so the ID is not randomly generated after a startup and register.
 * All RunningCloudManagementServices do have a RedisClientProvider cause of the nature this cloud is
 * coming from. All services have to communicate with each other using redis which is why all
 * RunningCloudManagementServices do have a RedisClientProvider. The object is created at the startup of
 * such a service and will be registered after boot up.
 */
public interface RunningCloudManagementService {

    /**
     * This provides the redis client provider used to communicate with each other part
     * of this cloud.
     * @return - A redis client provider containing a client
     */
    RedisClientProvider getRedissonClientProvider();

    /**
     * This return the type of running service (RUNNER/MASTER)
     * @return - The type of the running service
     */
    RunningCloudManagementServiceType type();

    /**
     * The unique id which is environmental dependent and is or should mainly be set via an environmental variable
     * @return - The unique id of this running service
     */
    String uid();

}
