package services.Driver;

import model.DAO.Impl.DriverDAOImpl;
import model.Entities.City;
import model.Entities.Driver;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * The type Add new driver.
 */
public class AddNewDriver {

    private static Logger logger = Logger.getLogger(AddNewDriver.class);

    /**
     * Add new driver boolean.
     *
     * @param firstName      the first name
     * @param lastName       the last name
     * @param sessionFactory the session factory
     * @return the boolean
     */
    public static boolean addNewDriver(String firstName, String lastName, String currentCity, SessionFactory sessionFactory) {
        boolean result = false;
        Session session = null;
        Driver driver = null;
        logger.info(String.format("Adding new driver: %s, %s", firstName, lastName));
        try {
            session = sessionFactory.openSession();
            DriverDAOImpl driverDAO = new DriverDAOImpl(session);
            City city = new City();
            city.setCityId(Integer.parseInt(currentCity));
            driver = new Driver(firstName, lastName, city);

            Transaction transaction = session.beginTransaction();
            driverDAO.create(driver);
            transaction.commit();

            result = true;
            logger.info("New driver added successfully");
        } catch (Throwable e) {
            logger.info("New driver doesn't added");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
