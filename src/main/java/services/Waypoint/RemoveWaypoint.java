package services.Waypoint;

import model.DAO.Impl.WaypointDAOImpl;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class RemoveWaypoint {

    private static Logger logger = Logger.getLogger(RemoveWaypoint.class);

    public static void removeWaypoint(int id, SessionFactory sessionFactory) {
        logger.info("Removing waypoint with id:" + id);

        Session session = null;
        try {
            session = sessionFactory.openSession();
            WaypointDAOImpl waypointDAO = new WaypointDAOImpl(session);

            Transaction transaction = session.beginTransaction();
            waypointDAO.delete(id);
            transaction.commit();

            logger.info("Waypoint removed successfully");

        } catch (HibernateException e) {
            logger.info("Error during removing waypoint id:" + id);
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}
