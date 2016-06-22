package services.Order;

import model.DAO.Impl.OrderDAOImpl;
import model.Entities.Order;
import model.Entities.OrderStatus;
import model.Entities.Wagon;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * The type Update order.
 */
public class UpdateOrder {

    private static Logger logger = Logger.getLogger(UpdateOrder.class);

    /**
     * Update order.
     *
     * @param id             the id
     * @param orderStatusId  the order status id
     * @param orderWagonId   the order wagon id
     * @param sessionFactory the session factory
     */
    public static void updateOrder(int id, String orderStatusId, String orderWagonId, SessionFactory sessionFactory) {
        logger.info("Trying to update Order with id:" + id);
        Session session = null;

        try {
            session = sessionFactory.openSession();
            OrderDAOImpl orderDAO = new OrderDAOImpl(session);

            Transaction transaction = session.beginTransaction();

            Order order = (Order) orderDAO.read(id);
            if (orderStatusId != null) {
                OrderStatus orderStatus = new OrderStatus();
                orderStatus.setOrderStatusId(Integer.parseInt(orderStatusId));
                order.setOrderStatus(orderStatus);
            }

            if (orderWagonId != null && !orderWagonId.equals("") && !orderWagonId.equals("null")) {
                Wagon wagon = new Wagon();
                wagon.setWagonId(Integer.parseInt(orderWagonId));
                order.setOrderWagon(wagon);
            }

            transaction.commit();

            logger.info("Order with id:" + id + " updated successfully");

        } catch (HibernateException e) {
            logger.info("Order with id:" + id + " doesn't updated");
            e.printStackTrace();
        } finally {
            session.close();
        }


    }
}
