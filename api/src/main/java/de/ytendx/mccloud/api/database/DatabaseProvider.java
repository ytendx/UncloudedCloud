package de.ytendx.mccloud.api.database;

import org.hibernate.SessionFactory;

public interface DatabaseProvider {

    void addEntity(Class<?> entity);

    SessionFactory getSessionFactory();
}
