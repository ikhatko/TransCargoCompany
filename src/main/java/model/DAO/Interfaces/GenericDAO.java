package model.DAO.Interfaces;

import java.util.List;

public interface GenericDAO<T> {

    void create(T entity);

    T read(int id);

    void update(T entity);

    void delete(int id);

    List<T> getAll();
}
