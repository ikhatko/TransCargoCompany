package model.DAO.Impl;

import model.DAO.Interfaces.UserDAO;
import org.hibernate.Session;

public class UserDAOImpl  extends GenericDAOImpl  implements UserDAO {

    public UserDAOImpl(Class entityType, Session session) {
        super(entityType, session);
    }
}
