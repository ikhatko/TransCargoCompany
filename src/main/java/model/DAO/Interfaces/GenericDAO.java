package model.DAO.Interfaces;

import java.util.List;

/**
 * The interface Generic dao.
 *
 * @param <T> the type parameter
 */
public interface GenericDAO<T> {

    /**
     * Create.
     *
     * @param entity the entity
     */
    void create(T entity);

    /**
     * Read t.
     *
     * @param id the id
     * @return the t
     */
    T read(int id);

    /**
     * Update.
     *
     * @param entity the entity
     */
    void update(T entity);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(int id);

    /**
     * Gets all.
     *
     * @return the all
     */
    List<T> getAll();
}
