package de.ytendx.mccloud.common.management.status;

import de.ytendx.mccloud.api.management.status.content.runner.RunnerReportContent;
import de.ytendx.mccloud.api.redis.RedisClientProvider;
import de.ytendx.mccloud.api.management.status.StatusReport;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class StatusHandler {

    private final List<StatusReport> lastReports;

    public StatusHandler(RedisClientProvider redisClientProvider) {
        this.lastReports = new CopyOnWriteArrayList<>();

        redisClientProvider.client().getTopic("status").addListener(StatusReport.class, (channel, msg) -> {
            if(getByID(msg.senderUID()) == null){
                lastReports.add(msg);
                handleStatusReport(null, msg);
                return;
            }

            handleStatusReport(getByID(msg.senderUID()), msg);
        });
    }

    public String getRunnerUIDFromLeastUsedRunnerManagementService(){
        return lastReports.stream()
                .filter(statusReport -> statusReport.reportContent() instanceof RunnerReportContent)
                .min(Comparator.comparingInt(o -> o.reportContent().loadContent().ramUsageInMB()))
                .map(StatusReport::senderUID)
                .orElse(null);
    }

    public StatusReport getByID(String id){
        for(StatusReport report : lastReports){
            if(report.senderUID().equals(id)){
                return report;
            }
        }
        return null;
    }

    public abstract void handleStatusReport(StatusReport lastReport, StatusReport report);
}
