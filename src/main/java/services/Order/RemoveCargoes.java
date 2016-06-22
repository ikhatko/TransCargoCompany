package services.Order;

import model.DAO.Impl.OrderDAOImpl;
import model.Entities.Cargo;
import model.Entities.Order;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Set;

/**
 * The type Update order.
 */
public class RemoveCargoes {

    private static Logger logger = Logger.getLogger(RemoveCargoes.class);

    /**
     * Update order.
     *
     * @param id             the id
     * @param orderStatusId  the order status id
     * @param orderWagonId   the order wagon id
     * @param sessionFactory the session factory
     */
    public static void removeCargoes(String orderId, String[] cargoes, SessionFactory sessionFactory) {
        logger.info("Trying to remove cargoes"
                + "from order with id:" + orderId);
        Session session = null;

        try {
            session = sessionFactory.openSession();
            OrderDAOImpl orderDAO = new OrderDAOImpl(session);
            Transaction transaction = session.beginTransaction();

            Order order = (Order) orderDAO.read(Integer.parseInt(orderId));

            Set<Cargo> cargoSet = order.getCargoSet();
            for (Cargo cargo : cargoSet) {
                for (String cargoId : cargoes) {
                    if (cargo.getCargoId() == Integer.parseInt(cargoId)) {
                        cargo.setCargoOrder(null);
                    }
                }
            }

            transaction.commit();

            logger.info("Cargoes removed from order id:" + orderId);

        } catch (HibernateException e) {
            logger.error("Cargoes doesn't removed from order id:" + orderId);
            e.printStackTrace();
        } finally {
            session.close();
        }


    }
}
