package de.ytendx.mccloud.api.management.status.content;

import de.ytendx.mccloud.api.management.IRunningCloudManagementService;

public abstract non-sealed class RunnerReportContent implements IReportContent{

    public abstract IRunningCloudManagementService service();
    public abstract int onlineServices();

}
