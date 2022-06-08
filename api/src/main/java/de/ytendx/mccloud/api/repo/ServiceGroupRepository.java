package de.ytendx.mccloud.api.repo;

import de.ytendx.mccloud.api.entity.ServiceGroup;

import java.util.List;

public interface ServiceGroupRepository extends CRUDRepository<ServiceGroup, Long> {

    List<ServiceGroup> findSome();
}
