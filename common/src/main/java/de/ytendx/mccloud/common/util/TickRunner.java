package de.ytendx.mccloud.common.util;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class TickRunner {

    public static void startTheTicker(Runnable runnable){
        Executors.newSingleThreadScheduledExecutor(r -> new Thread(r, "unclouded-cloud-ticker-" + UUID.randomUUID()))
                .scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);
    }

}
