package model.DAO.Impl;

import model.DAO.Interfaces.UserDAO;
import model.Entities.User;
import org.hibernate.Session;

public class UserDAOImpl extends GenericDAOImpl implements UserDAO {

    public UserDAOImpl(Session session) {
        super(User.class, session);
    }
}
