package de.ytendx.mccloud.common.database;

import de.ytendx.mccloud.api.database.IDatabaseProvider;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public final class DatabaseProviderImpl implements IDatabaseProvider {
    private final Configuration configuration;
    private SessionFactory sessionFactory;

    public DatabaseProviderImpl(String url, String user, String password, int minIdle, int maxConn) {
        this.configuration = new Configuration()
                .setProperty("hibernate.connection.provider_class", "org.hibernate.hikaricp.internal.HikariCPConnectionProvider")
                .setProperty("hibernate.hikari.minimumIdle", String.valueOf(minIdle))
                .setProperty("hibernate.hikari.maximumPoolSize", String.valueOf(maxConn))
                .setProperty("hibernate.hikari.idleTimeout", "60000")
                .setProperty("hibernate.hikari.dataSourceClassName", "org.postgresql.ds.PGSimpleDataSource")
                .setProperty("dialect", "org.hibernate.dialect.PostgreSQL10Dialect")
                .setProperty("hbm2ddl.auto", "update")
                .setProperty("hibernate.hikari.dataSource.url", url)
                .setProperty("hibernate.hikari.dataSource.user", user)
                .setProperty("hibernate.hikari.dataSource.password", password);
    }

    public void addEntity(Class<?> entity) {
        configuration.addAnnotatedClass(entity);
    }

    @Override
    public SessionFactory getSessionFactory() {
        if (sessionFactory != null) {
            return sessionFactory;
        }

        var serviceRegistryBuilder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());

        try (var serviceRegistry = serviceRegistryBuilder.build()) {
            try (var sessionFactory = configuration.buildSessionFactory()) {
                this.sessionFactory = sessionFactory;
                return configuration.buildSessionFactory(serviceRegistry);
            }
        }
    }
}
