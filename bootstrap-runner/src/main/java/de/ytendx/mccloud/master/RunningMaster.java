package de.ytendx.mccloud.master;

import de.ytendx.mccloud.api.management.impl.RunningMasterCloudService;
import de.ytendx.mccloud.api.redis.RedisClientProvider;
import de.ytendx.mccloud.api.redis.requesting.RedisRequestAnswer;
import de.ytendx.mccloud.api.redis.requesting.RedisRequestPool;
import de.ytendx.mccloud.api.redis.requesting.RedisRequestQuestion;
import de.ytendx.mccloud.api.running.RuntimeExecutable;
import de.ytendx.mccloud.api.ticker.TickingService;
import de.ytendx.mccloud.common.minio.MinIOProvider;
import de.ytendx.mccloud.common.redis.requesting.RedisRequestPoolImpl;
import de.ytendx.mccloud.common.redisservice.GeneralRedisContainer;
import de.ytendx.mccloud.common.redisservice.ManagementRedisContainer;
import de.ytendx.mccloud.common.util.TickRunner;
import de.ytendx.mccloud.master.configuration.MasterEnvVariableValueContainer;
import de.ytendx.mccloud.master.management.RunnerManager;
import de.ytendx.mccloud.master.management.ServiceManager;
import de.ytendx.mccloud.master.management.watcher.StatusMaintainer;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public final class RunningMaster extends RunningMasterCloudService implements RuntimeExecutable, TickingService {

    public static RunningMaster INSTANCE;

    private final String UNIQUE_ID = System.getenv("RUNNER_UID");
    private final GeneralRedisContainer generalRedisContainer;
    private final ManagementRedisContainer managementRedisContainer;
    private final MasterEnvVariableValueContainer configurationValueContainer;
    private final Logger logger = LoggerFactory.getLogger("mccloud-master");
    private final StatusMaintainer statusMaintainer;
    private final RunnerManager runnerManager;
    private final ServiceManager serviceManager;
    private final MinIOProvider minIOProvider;

    public RunningMaster(RedisClientProvider iRedisClientProvider,
                         MasterEnvVariableValueContainer masterEnvironmentVarContainer) {
        super(iRedisClientProvider);

        this.configurationValueContainer = masterEnvironmentVarContainer;

        this.generalRedisContainer = new GeneralRedisContainer(iRedisClientProvider);
        this.managementRedisContainer = new ManagementRedisContainer(iRedisClientProvider);
        this.statusMaintainer = new StatusMaintainer(iRedisClientProvider);

        this.runnerManager = new RunnerManager(this);
        this.serviceManager = new ServiceManager(this, runnerManager);

        this.minIOProvider = new MinIOProvider(
                masterEnvironmentVarContainer.getMinIOEndpoint(),
                masterEnvironmentVarContainer.getMinIOAccessKey(),
                masterEnvironmentVarContainer.getMinIOSecretKey()
        );
    }

    @Override
    public String uid() {
        return UNIQUE_ID;
    }

    @Override
    public void start(String[] args) {
        INSTANCE = this;
        //managementRedisContainer.getManagementServices().put(this.UNIQUE_ID, this);

        // Start ticker
        TickRunner.startTheTicker(this::tick);

        System.out.println(configurationValueContainer.getMinIOAccessKey() + "  " + configurationValueContainer.getMinIOSecretKey());

        var items = minIOProvider.fetchAllItems();

        items.forEach(item -> {
            System.out.println(item.objectName());
        });

        this.minIOProvider.downloadItems(minIOProvider.fetchAllItems(), "./config");
    }

    @Override
    public void stop(String reason) {
        
    }

    @Override
    public void tick() {
        runnerManager.tick();
        serviceManager.tick();
    }
}
