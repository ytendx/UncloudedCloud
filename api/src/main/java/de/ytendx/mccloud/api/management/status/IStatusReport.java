package de.ytendx.mccloud.api.management.status;

import de.ytendx.mccloud.api.management.status.content.IReportContent;

public interface IStatusReport {

    String senderUID();
    IReportContent reportContent();

}
