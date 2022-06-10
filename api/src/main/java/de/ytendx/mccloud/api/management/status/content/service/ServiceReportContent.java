package de.ytendx.mccloud.api.management.status.content.service;

import de.ytendx.mccloud.api.management.status.content.ReportContent;
import de.ytendx.mccloud.api.service.Service;

public abstract non-sealed class ServiceReportContent implements ReportContent {

    public abstract Service service();
    public abstract int onlinePlayers();
    public abstract double mspt();

}
