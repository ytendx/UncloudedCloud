package de.ytendx.mccloud.master.management.watcher;

import de.ytendx.mccloud.api.management.status.StatusReport;
import de.ytendx.mccloud.api.management.status.content.runner.RunnerReportContent;
import de.ytendx.mccloud.api.management.status.content.service.ServiceReportContent;
import de.ytendx.mccloud.api.redis.RedisClientProvider;
import de.ytendx.mccloud.api.service.ServiceState;
import de.ytendx.mccloud.common.management.status.StatusHandler;

public class StatusMaintainer extends StatusHandler {
    public StatusMaintainer(RedisClientProvider redisClientProvider) {
        super(redisClientProvider);
    }

    @Override
    public void handleStatusReport(StatusReport lastReport, StatusReport report) {
        if(report.reportContent() instanceof ServiceReportContent reportContent){
            ServiceReportContent lastContent = (ServiceReportContent) lastReport.reportContent();

            if(lastContent.service().state().equals(ServiceState.RUNNING)){

            }

        }else if(report.reportContent() instanceof RunnerReportContent reportContent){



        }
    }
}
