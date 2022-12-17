package de.ytendx.mccloud.common.management.internal;

import de.ytendx.mccloud.common.configuration.EnviromentalConfigurationValueContainer;
import de.ytendx.mccloud.common.minio.MinIOProvider;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConfigCacheService {

    private final MinIOProvider minIOProvider;
    private final ScheduledExecutorService scheduledExecutorService;
    private final EnviromentalConfigurationValueContainer valueContainer;

    private final FileManager fileManager;

    /**
     * Initialize the caching service for the config
     *
     * @param minIOProvider - The minio provider given
     * @param scheduledExecutorService - A scheduled executor service
     * @param valueContainer - The value container
     * @param fileManager - Requires to be already initialized!
     */
    public ConfigCacheService(
            MinIOProvider minIOProvider,
            ScheduledExecutorService scheduledExecutorService,
            EnviromentalConfigurationValueContainer valueContainer,
            FileManager fileManager) {
        this.minIOProvider = minIOProvider;
        this.scheduledExecutorService = scheduledExecutorService;
        this.valueContainer = valueContainer;
        this.fileManager = fileManager;
    }

    public void start() {
        scheduledExecutorService.scheduleAtFixedRate(
                this::cache,
                0,
                Long.parseLong(valueContainer.getConfigCacheRenewDelay()),
                TimeUnit.SECONDS
        );
    }

    public void cache(){
        var itemsToCache = minIOProvider.fetchAllItems();

        if (!fileManager.getConfigCacheDirectory().exists()){
            fileManager.getConfigCacheDirectory().mkdirs();
        }

        minIOProvider.downloadItems(itemsToCache, valueContainer.getConfigCachePath());
    }

}
