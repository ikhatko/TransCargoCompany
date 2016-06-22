package services.Order;

import model.DAO.Impl.OrderDAOImpl;
import model.DAO.Impl.WagonDAOImpl;
import model.Entities.Order;
import model.Entities.Wagon;
import model.Entities.WagonStatus;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * The type Add wagon to order.
 */
public class AddWagonToOrder {
    private static Logger logger = Logger.getLogger(AddWagonToOrder.class);

    /**
     * Add wagon.
     *
     * @param wagon          the wagon
     * @param orderId        the order id
     * @param sessionFactory the session factory
     */
    public static void addWagon(String wagon, String orderId,
                                SessionFactory sessionFactory) {
        logger.info("Trying to add wagon id: " + wagon + " to order id:" + orderId);
        Session session = null;
        try {
            session = sessionFactory.openSession();
            OrderDAOImpl orderDAO = new OrderDAOImpl(session);
            WagonDAOImpl wagonDAO = new WagonDAOImpl(session);

            Transaction transaction = session.beginTransaction();

            Order order = (Order) orderDAO.read(Integer.parseInt(orderId));
            Wagon orderWagon = (Wagon) wagonDAO.read(Integer.parseInt(wagon));

            if (order.getOrderWagon() != null) {
                Wagon currentWagon = order.getOrderWagon();
                WagonStatus wagonStatus = new WagonStatus();
                wagonStatus.setWagonStatusId(1);
                currentWagon.setWagonStatus(wagonStatus);
                order.setOrderWagon(null);
            }

            WagonStatus wagonStatus = new WagonStatus();
            wagonStatus.setWagonStatusId(3);
            orderWagon.setWagonStatus(wagonStatus);
            order.setOrderWagon(orderWagon);

            transaction.commit();

            logger.info("Wagon added successfully");

        } catch (HibernateException e) {
            logger.info("Error during adding wagon id:" + wagon + "to order id:" + orderId);
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
