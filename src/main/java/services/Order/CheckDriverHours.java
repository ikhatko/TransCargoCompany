package services.Order;

import model.DAO.Impl.DriverDAOImpl;
import model.DAO.Impl.OrderDAOImpl;
import model.Entities.Driver;
import model.Entities.DriverStatus;
import model.Entities.Order;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * The type Check driver hours.
 */
public class CheckDriverHours {
    /**
     * The constant MAX_MONTHS_HOURS.
     */
    public static final int MAX_MONTHS_HOURS = 176;
    private static Logger logger = Logger.getLogger(CheckDriverHours.class);

    /**
     * Check driver hours boolean.
     *
     * @param driverId       the driver id
     * @param orderId        the order id
     * @param sessionFactory the session factory
     * @return the boolean
     */
    public static boolean checkDriverHours(String driverId, String orderId,
                                           SessionFactory sessionFactory) {
        logger.info("Checking driver id:" + driverId);

        boolean result = false;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            OrderDAOImpl orderDAO = new OrderDAOImpl(session);
            DriverDAOImpl driverDAO = new DriverDAOImpl(session);

            Transaction transaction = session.beginTransaction();

            Order order = (Order) orderDAO.read(Integer.parseInt(orderId));
            Driver driver = (Driver) driverDAO.read(Integer.parseInt(driverId));

            float routeDuration = order.getRouteDuration();
            float thisMonthHours = driver.getThisMonthHours();

            if ((thisMonthHours + routeDuration) < MAX_MONTHS_HOURS) {
                result = true;
            }

            transaction.commit();

            logger.info("Drivers checked successfully");

        } catch (Exception e) {
            logger.error("Error during adding drivers to order id:" + orderId);
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
