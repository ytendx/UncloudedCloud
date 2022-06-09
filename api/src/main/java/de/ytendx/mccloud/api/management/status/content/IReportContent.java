package de.ytendx.mccloud.api.management.status.content;

public sealed interface IReportContent permits RunnerReportContent, ServiceReportContent {
    IDeviceLoadContent loadContent();
}
