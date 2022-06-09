package de.ytendx.mccloud.api.management.status.content;

import de.ytendx.mccloud.api.service.IService;

public abstract non-sealed class ServiceReportContent implements IReportContent{

    public abstract IService service();
    public abstract int onlinePlayers();
    public abstract double mspt();

}
