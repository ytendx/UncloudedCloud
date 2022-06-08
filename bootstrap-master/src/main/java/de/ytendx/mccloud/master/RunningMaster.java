package de.ytendx.mccloud.master;

import de.ytendx.mccloud.common.redisservice.GeneralRedisContainer;
import de.ytendx.mccloud.common.redisservice.ManagementRedisContainer;
import de.ytendx.mccloud.common.util.TickRunner;
import de.ytendx.mccloud.management.impl.RunningMasterCloudService;
import de.ytendx.mccloud.master.configuration.EnviromentalConfigurationValueContainer;
import de.ytendx.mccloud.redis.IRedisClientProvider;
import de.ytendx.mccloud.running.IRuntimeExecutable;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

@Getter
public class RunningMaster extends RunningMasterCloudService implements IRuntimeExecutable {

    public static RunningMaster INSTANCE;

    private final String UNIQUE_ID = UUID.randomUUID().toString();
    private final GeneralRedisContainer generalRedisContainer;
    private final ManagementRedisContainer managementRedisContainer;
    private final EnviromentalConfigurationValueContainer configurationValueContainer;
    private final Logger logger = LoggerFactory.getLogger("mccloud-master");

    public RunningMaster(IRedisClientProvider iRedisClientProvider, EnviromentalConfigurationValueContainer enviromentalConfigurationValueContainer) {
        super(iRedisClientProvider);
        this.configurationValueContainer = enviromentalConfigurationValueContainer;
        this.generalRedisContainer = new GeneralRedisContainer(iRedisClientProvider);
        this.managementRedisContainer = new ManagementRedisContainer(iRedisClientProvider);
    }

    @Override
    public String uid() {
        return UNIQUE_ID;
    }

    @Override
    public void start(String[] args) {
        INSTANCE = this;
        managementRedisContainer.getManagementServices().add(this);

        // Start ticker
        TickRunner.startTheTicker(this::tick);
    }

    @Override
    public void stop(String reason) {
        
    }

    @Override
    public void tick() {

    }
}
