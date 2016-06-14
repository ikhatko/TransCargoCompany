package services.Waypoint;

import model.DAO.Impl.WaypointDAOImpl;
import model.Entities.Cargo;
import model.Entities.City;
import model.Entities.Waypoint;
import model.Entities.WaypointType;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * The type Add new waypoint.
 */
public class AddNewWaypoint {

    private static Logger logger = Logger.getLogger(AddNewWaypoint.class);

    /**
     * Add new waypoint boolean.
     *
     * @param waypointCargoId the waypoint cargo id
     * @param waypointTypeId  the waypoint type id
     * @param waypointCityId  the waypoint city id
     * @param sessionFactory  the session factory
     * @return the boolean
     */
    public static boolean addNewWaypoint(String waypointCargoId, String waypointTypeId, String waypointCityId, SessionFactory sessionFactory) {
        boolean result = false;
        Session session = null;
        Waypoint waypoint = null;
        logger.info(String.format("Adding new waypoint for cargo: %s, type: %s", waypointCargoId, waypointTypeId));
        try {
            session = sessionFactory.openSession();
            WaypointDAOImpl waypointDAO = new WaypointDAOImpl(session);
            waypoint = new Waypoint();
            if (waypointCargoId != null) {
                Cargo cargo = new Cargo();
                cargo.setCargoId(Integer.parseInt(waypointCargoId));
                waypoint.setWaypointCargo(cargo);
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
            waypointDAO.create(waypoint);
            transaction.commit();

            result = true;
            logger.info("New waypoint added successfully");

        } catch (Throwable e) {
            logger.info("New waypoint doesn't added");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
