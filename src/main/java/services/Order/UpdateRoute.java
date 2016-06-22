package services.Order;

import model.DAO.Impl.OrderDAOImpl;
import model.Entities.*;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * The type Update route.
 */
public class UpdateRoute {

    private static Logger logger = Logger.getLogger(UpdateRoute.class);

    /**
     * Update route.
     *
     * @param orderId        the order id
     * @param sessionFactory the session factory
     */
    public static void updateRoute(String orderId, SessionFactory sessionFactory) {
        logger.info("Trying to update order route with id:" + orderId);
        Session session = null;

        try {
            session = sessionFactory.openSession();
            OrderDAOImpl orderDAO = new OrderDAOImpl(session);

            Transaction transaction = session.beginTransaction();

            Order order = (Order) orderDAO.read(Integer.parseInt(orderId));
            if (order.getCargoSet().isEmpty()) {
                for (Waypoint waypoint : order.getWaypointList()) {
                    waypoint.setWaypointOrder(null);
                }
                for (Driver driver : order.getDriverSet()) {
                    DriverStatus driverStatus = new DriverStatus();
                    driverStatus.setDriverStatusId(1);
                    driver.setDriverStatus(driverStatus);
                    driver.setCurrentOrder(null);
                }
                Wagon orderWagon = order.getOrderWagon();
                if (orderWagon != null) {
                    WagonStatus wagonStatus = new WagonStatus();
                    wagonStatus.setWagonStatusId(1);
                    orderWagon.setWagonStatus(wagonStatus);
                }
                order.setOrderWagon(null);
                order.setMaxVolume(0);
                order.setMaxWeight(0);
                order.setRouteDistance(0);
                order.setRouteDuration(0);
            } else {
                SetWeightAndVolume setWeightAndVolume = new SetWeightAndVolume();
                setWeightAndVolume.setMaxWeightAndVolume(orderId, sessionFactory);
            }

            transaction.commit();

            logger.info("Order with id:" + orderId + " updated successfully");

        } catch (HibernateException e) {
            logger.error("Order with id:" + orderId + " doesn't updated");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
