package services.User;

import model.DAO.Impl.UserDAOImpl;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class RemoveUser {

    private static Logger logger = Logger.getLogger(RemoveUser.class);

    public static void removeUser(int id, SessionFactory sessionFactory) {
        logger.info("Removing user with id:" + id);

        Session session = null;
        try {
            session = sessionFactory.openSession();
            UserDAOImpl userDAO = new UserDAOImpl(session);

            Transaction transaction = session.beginTransaction();
            userDAO.delete(id);
            transaction.commit();

            logger.info("User removed successfully");

        } catch (HibernateException e) {
            logger.info("Error during removing user id:" + id);
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}
