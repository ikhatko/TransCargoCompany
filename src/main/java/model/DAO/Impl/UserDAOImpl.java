package model.DAO.Impl;

import model.DAO.Interfaces.UserDAO;
import model.Entities.User;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * The type User dao.
 */
public class UserDAOImpl extends GenericDAOImpl implements UserDAO {

    /**
     * Instantiates a new User dao.
     *
     * @param session the session
     */
    public UserDAOImpl(Session session) {
        super(User.class, session);
    }

    public User checkUser(String email, String password, Session session) {
        User user = null;
        Query query = session.createQuery("from User where email=:email AND password=:password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        user = (User) query.uniqueResult();
        return user;
    }
}
