package de.ytendx.mccloud.api.repo;

import de.ytendx.mccloud.api.entity.ServiceGroupModel;

import java.util.List;

public interface ServiceGroupRepository extends CRUDRepository<ServiceGroupModel, Long> {

    List<ServiceGroupModel> findSome();
}
