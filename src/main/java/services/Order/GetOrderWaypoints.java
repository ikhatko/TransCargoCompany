package services.Order;

import model.DAO.Impl.OrderDAOImpl;
import model.Entities.Waypoint;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class GetOrderWaypoints {
    private static Logger logger = Logger.getLogger(GetOrderWaypoints.class);

    public static List<Waypoint> getOrderWaypoints(String orderId, SessionFactory sessionFactory) {
        logger.info("Trying to get all order waypoints");
        Session session = null;
        List<Waypoint> all = null;
        try {
            session = sessionFactory.openSession();
            OrderDAOImpl orderDAO = new OrderDAOImpl(session);

            Transaction transaction = session.beginTransaction();
            all = orderDAO.getOrderWaypointsList(Integer.parseInt(orderId));
            transaction.commit();

            if (!all.isEmpty()) {
                logger.info("List of order waypoints successfully received");
            } else {
                logger.info("Order waypoints list is empty.");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return all;
    }
}
