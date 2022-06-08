package de.ytendx.mccloud.common.util;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TickRunner {

    public static void startTheTicker(Runnable runnable){
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(runnable, 1, 5, TimeUnit.SECONDS);
    }

}
