package de.ytendx.mccloud.api.running;

public interface RuntimeExecutable {

    void start(String[] args);
    void stop(String reason);

}
