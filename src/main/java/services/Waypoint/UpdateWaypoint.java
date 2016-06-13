package services.Waypoint;

import model.DAO.Impl.WaypointDAOImpl;
import model.Entities.*;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UpdateWaypoint {

    private static Logger logger = Logger.getLogger(UpdateWaypoint.class);

    public static void updateWaypoint(int id, String waypointCargoId, String waypointTypeId, String waypointCityId, String orderId, SessionFactory sessionFactory) {
        logger.info("Trying to update Waypoint with id:" + id);
        Session session = null;

        try {
            session = sessionFactory.openSession();
            WaypointDAOImpl waypointDAO = new WaypointDAOImpl(session);
            Waypoint waypoint = (Waypoint) waypointDAO.read(id);

            if (waypointCargoId != null) {
                Cargo cargo = new Cargo();
                cargo.setCargoId(Integer.parseInt(waypointCargoId));
                waypoint.setWaypointCargo(cargo);
            }
            if (orderId != null) {
                Order order = new Order();
                order.setOrderId(Integer.parseInt(orderId));
                waypoint.setWaypointOrder(order);
            }

            if (waypointTypeId != null) {
                WaypointType waypointType = new WaypointType();
                waypointType.setWaypointTypeId(Integer.parseInt(waypointTypeId));
                waypoint.setWaypointType(waypointType);
            }

            if (waypointCityId != null) {
                City city = new City();
                city.setCityId(Integer.parseInt(waypointCityId));
                waypoint.setWaypointCity(city);
            }

            Transaction transaction = session.beginTransaction();
            transaction.commit();

            logger.info("Waypoint with id:" + id + " updated successfully");

        } catch (HibernateException e) {
            logger.info("Waypoint with id:" + id + " doesn't updated");
            e.printStackTrace();
        } finally {
            session.close();
        }


    }
}
