package services.Waypoint;

import model.DAO.Impl.WaypointDAOImpl;
import model.Entities.Waypoint;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class GetAllWaypoints {

    private static Logger logger = Logger.getLogger(GetAllWaypoints.class);

    public static List getAllWaypoints(SessionFactory sessionFactory) {
        logger.info("Trying to get all waypoints");
        Session session = null;
        List<Waypoint> all = null;
        try {
            session = sessionFactory.openSession();
            WaypointDAOImpl waypointDAO = new WaypointDAOImpl(session);

            Transaction transaction = session.beginTransaction();
            all = waypointDAO.getAll();
            transaction.commit();

            if (!all.isEmpty()) {
                logger.info("List of waypoints successfully received");
            } else {
                logger.info("Waypoints list is empty");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return all;
    }
}
