package de.ytendx.mccloud.running;

public interface IRuntimeExecutable {

    void start(String[] args);
    void stop(String reason);

}
