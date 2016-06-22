package services.Order;

import model.DAO.Impl.DriverDAOImpl;
import model.DAO.Impl.OrderDAOImpl;
import model.Entities.Order;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * The type Get order by driver id.
 */
public class GetOrderByDriverId {

    private static Logger logger = Logger.getLogger(GetOrderByDriverId.class);

    /**
     * Gets order by driver id.
     *
     * @param driverId       the driver id
     * @param sessionFactory the session factory
     * @return the order by driver id
     */
    public static Order getOrderByDriverId(String driverId, SessionFactory sessionFactory) {
        logger.info("Trying to get order by driver id:" + driverId);
        Session session = null;
        Order order = null;

        try {
            session = sessionFactory.openSession();
            DriverDAOImpl driverDAO = new DriverDAOImpl(session);
            Transaction transaction = session.beginTransaction();

            order = driverDAO.getOrderByDriverId(Integer.parseInt(driverId));

            transaction.commit();
            logger.info("Order by driver id:" + driverId + " received");

        } catch (Exception e) {
            logger.error(e.toString());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return order;
    }
}
