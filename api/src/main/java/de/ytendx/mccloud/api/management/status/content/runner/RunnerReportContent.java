package de.ytendx.mccloud.api.management.status.content.runner;

import de.ytendx.mccloud.api.management.RunningCloudManagementService;
import de.ytendx.mccloud.api.management.status.content.ReportContent;

public abstract class RunnerReportContent implements ReportContent {

    public abstract RunningCloudManagementService service();
    public abstract int onlineServices();

}
