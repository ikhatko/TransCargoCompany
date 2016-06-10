package model.DAO.Impl;

import model.DAO.Interfaces.GenericDAO;
import org.hibernate.Session;

public class GenericDAOImpl<T> implements GenericDAO<T> {
    private final Class<T> entityType;
    private Session session;

    public GenericDAOImpl(Class<T> entityType, Session session) {
        this.entityType = entityType;
        this.session = session;
    }

    public void create(T entity) {
        session.save(entity);
    }

    public T read(int id) {
        return (T) session.get(entityType, id);
    }

    public void update(T entity) {
        session.update(entity);
    }

    public void delete(int id) {
        session.delete(read(id));
    }
}
