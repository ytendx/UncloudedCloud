package de.ytendx.mccloud.master.configuration;

import de.ytendx.mccloud.common.configuration.EnviromentalConfigurationValueContainer;

public class MasterEnvVariableValueContainer extends EnviromentalConfigurationValueContainer {

    private String databaseURL;
    private String databasePassword;
    private String databaseUser;
    private int databaseMinIdle;
    private int maxDatabaseConnections;

    public MasterEnvVariableValueContainer() throws IllegalAccessException {
        super();
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public String getDatabaseURL() {
        return databaseURL;
    }

    public String getDatabaseUser() {
        return databaseUser;
    }

    public int getDatabaseMinIdle() {
        return databaseMinIdle;
    }

    public int getMaxDatabaseConnections() {
        return maxDatabaseConnections;
    }
}
