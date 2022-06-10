package de.ytendx.mccloud.master;

import de.ytendx.mccloud.api.database.DatabaseProvider;
import de.ytendx.mccloud.api.entity.ServiceGroup;
import de.ytendx.mccloud.api.management.impl.RunningMasterCloudService;
import de.ytendx.mccloud.api.redis.RedisClientProvider;
import de.ytendx.mccloud.api.repo.ServiceGroupRepository;
import de.ytendx.mccloud.api.running.RuntimeExecutable;
import de.ytendx.mccloud.common.database.DatabaseProviderImpl;
import de.ytendx.mccloud.common.redisservice.GeneralRedisContainer;
import de.ytendx.mccloud.common.redisservice.ManagementRedisContainer;
import de.ytendx.mccloud.common.repo.ServiceListRepositoryImpl;
import de.ytendx.mccloud.common.util.TickRunner;
import de.ytendx.mccloud.common.configuration.EnviromentalConfigurationValueContainer;
import de.ytendx.mccloud.master.configuration.MasterEnvVariableValueContainer;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

@Getter
public final class RunningMaster extends RunningMasterCloudService implements RuntimeExecutable {

    public static RunningMaster INSTANCE;

    private final String UNIQUE_ID = UUID.randomUUID().toString();
    private final GeneralRedisContainer generalRedisContainer;
    private final SessionFactory sessionFactory;
    private final ManagementRedisContainer managementRedisContainer;
    private final MasterEnvVariableValueContainer configurationValueContainer;
    private final Logger logger = LoggerFactory.getLogger("mccloud-master");
    private final DatabaseProvider databaseProvider;

    private final ServiceGroupRepository serviceGroupRepository;

    public RunningMaster(RedisClientProvider iRedisClientProvider,
                         SessionFactory sessionFactory,
                         MasterEnvVariableValueContainer masterEnviromentVarContainer) {
        super(iRedisClientProvider);

        this.sessionFactory = sessionFactory;
        this.configurationValueContainer = masterEnviromentVarContainer;
        this.generalRedisContainer = new GeneralRedisContainer(iRedisClientProvider);
        this.managementRedisContainer = new ManagementRedisContainer(iRedisClientProvider);

        this.serviceGroupRepository = new ServiceListRepositoryImpl(sessionFactory);

        this.databaseProvider = new DatabaseProviderImpl(
                masterEnviromentVarContainer.getDatabaseURL(),
                masterEnviromentVarContainer.getDatabaseUser(),
                masterEnviromentVarContainer.getDatabasePassword(),
                masterEnviromentVarContainer.getDatabaseMinIdle(),
                masterEnviromentVarContainer.getMaxDatabaseConnections()
        );

        // Add entities
        this.databaseProvider.addEntity(ServiceGroup.class);

        serviceGroupRepository.findAll();
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
