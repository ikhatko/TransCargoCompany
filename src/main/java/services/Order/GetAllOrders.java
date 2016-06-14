package services.Order;

import model.DAO.Impl.OrderDAOImpl;
import model.Entities.Order;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * The type Get all orders.
 */
public class GetAllOrders {

    private static Logger logger = Logger.getLogger(GetAllOrders.class);

    /**
     * Gets all orders.
     *
     * @param sessionFactory the session factory
     * @return the all orders
     */
    public static List getAllOrders(SessionFactory sessionFactory) {
        logger.info("Trying to get all orders");
        Session session = null;
        List<Order> all = null;
        try {
            session = sessionFactory.openSession();
            OrderDAOImpl orderDAO = new OrderDAOImpl(session);

            Transaction transaction = session.beginTransaction();
            all = orderDAO.getAll();
            transaction.commit();

            if (!all.isEmpty()) {
                logger.info("List of orders successfully received");
            } else {
                logger.info("Order list is empty.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return all;
    }
}
