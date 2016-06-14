package services.City;

import model.DAO.Impl.CityDAOImpl;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * The type Remove city.
 */
public class RemoveCity {

    private static Logger logger = Logger.getLogger(RemoveCity.class);

    /**
     * Remove city.
     *
     * @param id             the id
     * @param sessionFactory the session factory
     */
    public static void removeCity(int id, SessionFactory sessionFactory) {
        logger.info("Removing city with id:" + id);

        Session session = null;
        try {
            session = sessionFactory.openSession();
            CityDAOImpl cityDAO = new CityDAOImpl(session);

            Transaction transaction = session.beginTransaction();
            cityDAO.delete(id);
            transaction.commit();

            logger.info("City removed successfully");

        } catch (HibernateException e) {
            logger.info("Error during removing city id:" + id);
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}
