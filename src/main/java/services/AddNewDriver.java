package services;

import model.DAO.Impl.DriverDAOImpl;
import model.Entities.Driver;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AddNewDriver {

    private static Logger logger = Logger.getLogger(AddNewDriver.class);

    public static boolean addNewDriver(String firstName, String lastName, SessionFactory sessionFactory) {
        boolean result = false;
        Session session = null;
        Driver driver = null;
        logger.info(String.format("Adding new driver: %s, %s", firstName, lastName));
        try {
            session = sessionFactory.openSession();
            DriverDAOImpl driverDAO = new DriverDAOImpl(Driver.class, session);
            driver = new Driver(firstName, lastName);
            Transaction transaction = session.beginTransaction();
            driverDAO.create(driver);
            transaction.commit();
            result = true;
            logger.info("New driver added successfully");
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
