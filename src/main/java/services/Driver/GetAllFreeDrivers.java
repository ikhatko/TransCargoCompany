package services.Driver;

import model.DAO.Impl.DriverDAOImpl;
import model.Entities.Driver;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * The type Get all drivers.
 */
public final class GetAllFreeDrivers {

    private static Logger logger = Logger.getLogger(GetAllFreeDrivers.class);

    private GetAllFreeDrivers() {
    }

    /**
     * Gets all drivers.
     *
     * @param sessionFactory the session factory
     * @return the all drivers
     */
    public static List getAllFreeDrivers(SessionFactory sessionFactory) {
        logger.info("Trying to get all free drivers");
        Session session = null;
        List<Driver> all = null;
        try {
            session = sessionFactory.openSession();
            DriverDAOImpl driverDAO = new DriverDAOImpl(session);

            Transaction transaction = session.beginTransaction();
            all = driverDAO.getFreeDrivers();
            transaction.commit();
            if (!all.isEmpty()) {
                logger.info("List of free drivers successfully received");
            } else {
                logger.info("Free drivers list is empty");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return all;
    }
}
