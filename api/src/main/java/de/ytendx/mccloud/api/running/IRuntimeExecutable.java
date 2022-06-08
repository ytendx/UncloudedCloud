package de.ytendx.mccloud.api.running;

public interface IRuntimeExecutable {

    void start(String[] args);
    void stop(String reason);

}
