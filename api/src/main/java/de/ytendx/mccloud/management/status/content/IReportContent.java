package de.ytendx.mccloud.management.status.content;

public sealed interface IReportContent permits RunnerReportContent, ServiceReportContent {
    IDeviceLoadContent loadContent();
}
