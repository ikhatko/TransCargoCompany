package services.Wagon;

import model.DAO.Impl.WagonDAOImpl;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * The type Remove wagon.
 */
public class RemoveWagon {

    private static Logger logger = Logger.getLogger(RemoveWagon.class);

    /**
     * Remove wagon.
     *
     * @param id             the id
     * @param sessionFactory the session factory
     */
    public static void removeWagon(int id, SessionFactory sessionFactory) {
        logger.info("Removing wagon with id:" + id);

        Session session = null;
        try {
            session = sessionFactory.openSession();
            WagonDAOImpl wagonDAO = new WagonDAOImpl(session);

            Transaction transaction = session.beginTransaction();
            wagonDAO.delete(id);
            transaction.commit();

            logger.info("Wagon removed successfully");

        } catch (HibernateException e) {
            logger.info("Error during removing wagon id:" + id);
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}
