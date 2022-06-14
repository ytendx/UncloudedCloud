package de.ytendx.mccloud.common.repo;

import de.ytendx.mccloud.api.entity.ServiceGroupModel;
import de.ytendx.mccloud.api.repo.ServiceGroupRepository;
import org.hibernate.SessionFactory;

import java.util.List;

public final class ServiceListRepositoryImpl extends CRUDRepositoryImpl<ServiceGroupModel, Long> implements ServiceGroupRepository {
    public ServiceListRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory, ServiceGroupModel.class);
    }

    @Override
    public List<ServiceGroupModel> findSome() {
        return null;
    }
}
