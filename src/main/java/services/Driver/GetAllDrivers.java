package services.Driver;

import model.DAO.Impl.DriverDAOImpl;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class GetAllDrivers {

    private static Logger logger = Logger.getLogger(GetAllDrivers.class);

    public static List getAllDrivers(SessionFactory sessionFactory) {
        logger.info("Trying to get all drivers.");
        Session session = null;
        List all = null;
        try {
            session = sessionFactory.openSession();
            DriverDAOImpl driverDAO = new DriverDAOImpl(session);

            Transaction transaction = session.beginTransaction();
            all = driverDAO.getAll();
            transaction.commit();

            if (!all.isEmpty()) {
                logger.info("All drivers get successfully.");
            } else {
                logger.info("Drivers list is empty.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return all;
    }
}
