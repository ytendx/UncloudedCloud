package de.ytendx.mccloud.api.management.status;

import de.ytendx.mccloud.api.management.status.content.ReportContent;

public interface StatusReport {

    String senderUID();
    ReportContent reportContent();

}
