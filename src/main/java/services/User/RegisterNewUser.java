package services.User;

import model.DAO.Impl.UserDAOImpl;
import model.Entities.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * The type Register new user.
 */
public class RegisterNewUser {

    private static Logger logger = Logger.getLogger(RegisterNewUser.class);

    /**
     * Register new user boolean.
     *
     * @param firstName      the first name
     * @param lastName       the last name
     * @param email          the email
     * @param password       the password
     * @param sessionFactory the session factory
     * @return the boolean
     */
    public static boolean registerNewUser(String firstName, String lastName, String email, String password, SessionFactory sessionFactory) {
        logger.info(String.format("Trying to register new user:: %s , %s, %s", firstName, lastName, email));

        boolean result = false;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            User user = new User(firstName, lastName, email, password);
            UserDAOImpl userDAO = new UserDAOImpl(session);
            userDAO.create(user);
            transaction.commit();
            result = true;
            logger.info("New user registered.");
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
