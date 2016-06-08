package model.DAO.Impl;

import model.DAO.BaseDAO;
import org.hibernate.SessionFactory;

public class BaseDAOClass extends BaseDAO {
    public BaseDAOClass(Class entityType, SessionFactory sessionFactory) {
        super(entityType, sessionFactory);
    }
}
