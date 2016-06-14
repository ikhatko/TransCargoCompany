package services.Order;

import model.DAO.Impl.OrderDAOImpl;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * The type Remove order.
 */
public class RemoveOrder {

    private static Logger logger = Logger.getLogger(RemoveOrder.class);

    /**
     * Remove order.
     *
     * @param id             the id
     * @param sessionFactory the session factory
     */
    public static void removeOrder(int id, SessionFactory sessionFactory) {
        logger.info("Removing order with id:" + id);

        Session session = null;
        try {
            session = sessionFactory.openSession();
            OrderDAOImpl orderDAO = new OrderDAOImpl(session);

            Transaction transaction = session.beginTransaction();
            orderDAO.delete(id);
            transaction.commit();

            logger.info("Order removed successfully");

        } catch (HibernateException e) {
            logger.info("Error during removing order id:" + id);
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}
