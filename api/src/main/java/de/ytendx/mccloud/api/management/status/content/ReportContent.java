package de.ytendx.mccloud.api.management.status.content;

public sealed interface ReportContent permits RunnerReportContent, ServiceReportContent {
    DeviceLoadContent loadContent();
}
