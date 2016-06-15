package services.Cargo;

import model.DAO.Impl.CargoDAOImlp;
import model.DAO.Impl.WaypointDAOImpl;
import model.Entities.Cargo;
import model.Entities.City;
import model.Entities.Waypoint;
import model.Entities.WaypointType;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public final class AddTwoCargoWaypoints {
    private static Logger logger = Logger.getLogger(AddTwoCargoWaypoints.class);

    private AddTwoCargoWaypoints() {
    }

    public static void addCargoWaypoints(String name, String weight,
                                         String volume, String loadFrom,
                                         String unloadTo, SessionFactory sessionFactory) {
        logger.info("Adding cargo and two waypoints");
        Session session = sessionFactory.openSession();

        Cargo cargo = new Cargo(name, Float.parseFloat(weight),
                Float.parseFloat(volume));

        WaypointType waypointTypeLoad = new WaypointType();
        waypointTypeLoad.setWaypointTypeId(1);
        WaypointType waypointTypeUnload = new WaypointType();
        waypointTypeUnload.setWaypointTypeId(2);

        City cityLoad = new City();
        cityLoad.setCityId(Integer.parseInt(loadFrom));
        City cityUnload = new City();
        cityUnload.setCityId(Integer.parseInt(unloadTo));

        Waypoint waypointLoad = new Waypoint(cargo, waypointTypeLoad, cityLoad);
        Waypoint waypointUnload =
                new Waypoint(cargo, waypointTypeUnload, cityUnload);
        CargoDAOImlp cargoDAO = new CargoDAOImlp(session);
        WaypointDAOImpl waypointDAO = new WaypointDAOImpl(session);

        try {
            Transaction transaction = session.beginTransaction();

            cargoDAO.create(cargo);
            waypointDAO.create(waypointLoad);
            waypointDAO.create(waypointUnload);

            session.save(cargo);
            transaction.commit();
            logger.info("Cargo and waypoints created successfully");
        } catch (Exception e) {
            logger.info("Cargo and waypoints not created");
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}
