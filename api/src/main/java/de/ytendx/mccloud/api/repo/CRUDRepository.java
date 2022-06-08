package de.ytendx.mccloud.api.repo;

import java.util.List;

public interface CRUDRepository<T, V> {
    List<T> findAll();

    void save(T value);

    void update(T value);

    void saveOrUpdate(T value);

    void delete(T value);
}
