package services.User;

import model.DAO.Impl.UserDAOImpl;
import model.Entities.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * The type Get all users.
 */
public class GetAllUsers {

    private static Logger logger = Logger.getLogger(GetAllUsers.class);

    /**
     * Gets all users.
     *
     * @param sessionFactory the session factory
     * @return the all users
     */
    public static List getAllUsers(SessionFactory sessionFactory) {
        logger.info("Trying to get all users.");
        Session session = null;
        List<User> all = null;
        try {
            session = sessionFactory.openSession();
            UserDAOImpl userDAO = new UserDAOImpl(session);

            Transaction transaction = session.beginTransaction();
            all = userDAO.getAll();
            transaction.commit();

            if (!all.isEmpty()) {
                logger.info("List of users successfully received");
            } else {
                logger.info("Users list is empty.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return all;
    }
}
