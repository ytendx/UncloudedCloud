package de.ytendx.mccloud.common.redisservice.requesting;


public enum RequestingChannelDogma {

    SERVICE_START("service_start");

    private final String raw;

    RequestingChannelDogma(String raw) {
        this.raw = raw;
    }

    public String getRaw() {
        return raw;
    }
}
