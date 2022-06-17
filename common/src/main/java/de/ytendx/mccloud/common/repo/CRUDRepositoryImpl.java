package de.ytendx.mccloud.common.repo;

import de.ytendx.mccloud.api.redis.repo.CRUDRepository;
import org.hibernate.SessionFactory;

import java.util.List;

public class CRUDRepositoryImpl<T, V> implements CRUDRepository<T, V> {
    private final SessionFactory sessionFactory;
    private final Class<T> clazz;

    public CRUDRepositoryImpl(SessionFactory sessionFactory, Class<T> clazz) {
        this.sessionFactory = sessionFactory;
        this.clazz = clazz;
    }

    @Override
    public List<T> findAll() {
        try (var session = sessionFactory.openSession()) {
            var criteriaBuilder = session.getCriteriaBuilder();
            var criteriaQuery = criteriaBuilder.createQuery(clazz);

            var rootEntry = criteriaQuery.from(clazz);
            var all = criteriaQuery.select(rootEntry);
            var allQuery = session.createQuery(all);

            return allQuery.getResultList();
        }
    }

    @Override
    public void save(T value) {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();

            try {
                session.save(value);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                throw ex;
            }
        }
    }

    @Override
    public void update(T value) {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();

            try {
                session.update(value);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                throw ex;
            }
        }
    }

    @Override
    public void saveOrUpdate(T value) {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();

            try {
                session.saveOrUpdate(value);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                throw ex;
            }
        }
    }

    @Override
    public void delete(T value) {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();

            try {
                session.delete(value);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                throw ex;
            }
        }
    }
}
