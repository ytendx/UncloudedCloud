package de.ytendx.mccloud.common.management.internal;

import de.ytendx.mccloud.common.configuration.EnviromentalConfigurationValueContainer;
import lombok.Getter;

import java.io.File;

@Getter
public class FileManager {

    private EnviromentalConfigurationValueContainer configurationValueContainer;

    private final File staticDirectory, tempDirectory, configCacheDirectory;

    public FileManager(EnviromentalConfigurationValueContainer configurationValueContainer) {
        this.configurationValueContainer = configurationValueContainer;

        this.staticDirectory = new File(configurationValueContainer.getStaticPath());
        this.tempDirectory = new File(configurationValueContainer.getTempPath());
        this.configCacheDirectory = new File(configurationValueContainer.getConfigCachePath());
    }

    public void initFilesAndDirectories() {
        if (!staticDirectory.exists()){
            staticDirectory.mkdirs();
        }

        if(!tempDirectory.exists()) {
            tempDirectory.mkdirs();
        }

        if(!configCacheDirectory.exists()) {
            configCacheDirectory.mkdirs();
        }
    }

}
