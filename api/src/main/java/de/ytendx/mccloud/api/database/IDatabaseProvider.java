package de.ytendx.mccloud.api.database;

import org.hibernate.SessionFactory;

public interface IDatabaseProvider {

    void addEntity(Class<?> entity);

    SessionFactory getSessionFactory();
}
