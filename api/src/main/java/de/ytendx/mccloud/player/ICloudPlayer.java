package de.ytendx.mccloud.player;

import de.ytendx.mccloud.service.IService;
import de.ytendx.mccloud.service.impl.BukkitService;
import de.ytendx.mccloud.service.impl.ProxyService;

public interface ICloudPlayer {

    String name();
    String uuid();
    BukkitService currentBukkitService();
    ProxyService currentProxyService();
    void executeBukkitServerChange(BukkitService target);

}
