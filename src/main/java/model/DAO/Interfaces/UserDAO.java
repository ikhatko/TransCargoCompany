package model.DAO.Interfaces;

import model.Entities.User;
import org.hibernate.Session;

/**
 * The interface User dao.
 */
public interface UserDAO {
    /**
     * Check user user.
     *
     * @param email    the email
     * @param password the password
     * @param session  the session
     * @return the user
     */
    User checkUser(String email, String password, Session session);
}
