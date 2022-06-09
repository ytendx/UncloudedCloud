package de.ytendx.mccloud.api.management.status.content;

import de.ytendx.mccloud.api.management.RunningCloudManagementService;

public abstract non-sealed class RunnerReportContent implements ReportContent {

    public abstract RunningCloudManagementService service();
    public abstract int onlineServices();

}
