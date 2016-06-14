package model.DAO.Impl;

import model.DAO.Interfaces.GenericDAO;
import org.hibernate.Session;

import java.util.List;

/**
 * The type Generic dao.
 *
 * @param <T> the type parameter
 */
public class GenericDAOImpl<T> implements GenericDAO<T> {
    private final Class<T> entityType;
    private Session session;

    /**
     * Instantiates a new Generic dao.
     *
     * @param entityType the entity type
     * @param session    the session
     */
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
        session.saveOrUpdate(entity);
    }

    public void delete(int id) {
        session.delete(read(id));
    }

    public List<T> getAll() {
        return session.createCriteria(entityType).list();
    }


}
