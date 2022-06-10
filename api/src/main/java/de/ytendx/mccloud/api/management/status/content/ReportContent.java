package de.ytendx.mccloud.api.management.status.content;

import de.ytendx.mccloud.api.management.status.content.runner.RunnerReportContent;
import de.ytendx.mccloud.api.management.status.content.service.ServiceReportContent;

public sealed interface ReportContent permits RunnerReportContent, ServiceReportContent {
    DeviceLoadContent loadContent();
}
