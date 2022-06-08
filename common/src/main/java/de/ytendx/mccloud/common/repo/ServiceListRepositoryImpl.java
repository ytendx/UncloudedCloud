package de.ytendx.mccloud.common.repo;

import de.ytendx.mccloud.api.entity.ServiceGroup;
import de.ytendx.mccloud.api.repo.ServiceGroupRepository;
import org.hibernate.SessionFactory;

import java.util.List;

public final class ServiceListRepositoryImpl extends CRUDRepositoryImpl<ServiceGroup, Long> implements ServiceGroupRepository {
    public ServiceListRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory, ServiceGroup.class);
    }

    @Override
    public List<ServiceGroup> findSome() {
        return null;
    }
}
