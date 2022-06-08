package de.ytendx.mccloud.management.status.content;

import de.ytendx.mccloud.management.IRunningCloudManagementService;

public abstract non-sealed class RunnerReportContent implements IReportContent{

    public abstract IRunningCloudManagementService service();
    public abstract int onlineServices();

}
