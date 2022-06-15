package de.ytendx.mccloud.api.management.status.content;

import de.ytendx.mccloud.api.management.status.content.runner.RunnerReportContent;
import de.ytendx.mccloud.api.management.status.content.service.ServiceReportContent;

public interface ReportContent {
    DeviceLoadContent loadContent();
}
