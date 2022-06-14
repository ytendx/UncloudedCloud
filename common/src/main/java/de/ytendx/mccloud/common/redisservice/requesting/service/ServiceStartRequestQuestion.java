package de.ytendx.mccloud.common.redisservice.requesting.service;

import de.ytendx.mccloud.api.service.Service;
import de.ytendx.mccloud.common.redis.requesting.AbstractRedisRequestQuestion;

public class ServiceStartRequestQuestion extends AbstractRedisRequestQuestion {

    private final String serviceGroupName;
    private final Service service;

    public ServiceStartRequestQuestion(String serviceGroupName, Service service) {
        this.serviceGroupName = serviceGroupName;
        this.service = service;
    }

    public String getServiceGroupName() {
        return serviceGroupName;
    }

    public Service getService() {
        return service;
    }

    // TODO: Add desc

}
