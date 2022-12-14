package de.ytendx.mccloud.api.running;

public interface RuntimeExecutable {

    void tick();

    void start(String[] args);
    void stop(String reason);

}
