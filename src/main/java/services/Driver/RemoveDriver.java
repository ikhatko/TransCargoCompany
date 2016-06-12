package services.Driver;

import model.DAO.Impl.DriverDAOImpl;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class RemoveDriver {

    private static Logger logger = Logger.getLogger(RemoveDriver.class);

    public static void removeDriver(int id, SessionFactory sessionFactory) {
        logger.info("Removing driver with id:" + id);

        Session session = null;
        try {
            session = sessionFactory.openSession();
            DriverDAOImpl driverDAO = new DriverDAOImpl(session);

            Transaction transaction = session.beginTransaction();
            driverDAO.delete(id);
            transaction.commit();

            logger.info("Driver removed successfully");

        } catch (HibernateException e) {
            logger.info("Error during removing id:" + id);
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}
