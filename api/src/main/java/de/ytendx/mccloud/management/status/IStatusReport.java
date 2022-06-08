package de.ytendx.mccloud.management.status;

import de.ytendx.mccloud.management.status.content.IReportContent;

public interface IStatusReport {

    String senderUID();
    IReportContent reportContent();

}
