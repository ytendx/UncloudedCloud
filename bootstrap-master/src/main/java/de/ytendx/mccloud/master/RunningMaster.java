package de.ytendx.mccloud.master;

import de.ytendx.mccloud.api.management.impl.RunningMasterCloudService;
import de.ytendx.mccloud.api.redis.IRedisClientProvider;
import de.ytendx.mccloud.api.repo.ServiceGroupRepository;
import de.ytendx.mccloud.api.running.IRuntimeExecutable;
import de.ytendx.mccloud.common.redisservice.GeneralRedisContainer;
import de.ytendx.mccloud.common.redisservice.ManagementRedisContainer;
import de.ytendx.mccloud.common.repo.ServiceListRepositoryImpl;
import de.ytendx.mccloud.common.util.TickRunner;
import de.ytendx.mccloud.master.configuration.EnviromentalConfigurationValueContainer;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

@Getter
public final class RunningMaster extends RunningMasterCloudService implements IRuntimeExecutable {

    public static RunningMaster INSTANCE;

    private final String UNIQUE_ID = UUID.randomUUID().toString();
    private final GeneralRedisContainer generalRedisContainer;
    private final SessionFactory sessionFactory;
    private final ManagementRedisContainer managementRedisContainer;
    private final EnviromentalConfigurationValueContainer configurationValueContainer;
    private final Logger logger = LoggerFactory.getLogger("mccloud-master");

    private final ServiceGroupRepository serviceGroupRepository;

    public RunningMaster(IRedisClientProvider iRedisClientProvider,
                         SessionFactory sessionFactory,
                         EnviromentalConfigurationValueContainer enviromentalConfigurationValueContainer) {
        super(iRedisClientProvider);

        this.sessionFactory = sessionFactory;
        this.configurationValueContainer = enviromentalConfigurationValueContainer;
        this.generalRedisContainer = new GeneralRedisContainer(iRedisClientProvider);
        this.managementRedisContainer = new ManagementRedisContainer(iRedisClientProvider);

        this.serviceGroupRepository = new ServiceListRepositoryImpl(sessionFactory);

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
