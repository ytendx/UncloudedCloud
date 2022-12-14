package de.ytendx.mccloud.master.configuration;

import de.ytendx.mccloud.api.database.NullDefault;
import de.ytendx.mccloud.common.configuration.EnviromentalConfigurationValueContainer;

public class MasterEnvVariableValueContainer extends EnviromentalConfigurationValueContainer {

    private String minIOAccessKey;
    private String minIOEndpoint;
    private String minIOSecretKey;

    public MasterEnvVariableValueContainer() throws IllegalAccessException {
        super();
    }


    public String getMinIOAccessKey() {
        return minIOAccessKey;
    }

    public String getMinIOEndpoint() {
        return minIOEndpoint;
    }

    public String getMinIOSecretKey() {
        return minIOSecretKey;
    }
}
