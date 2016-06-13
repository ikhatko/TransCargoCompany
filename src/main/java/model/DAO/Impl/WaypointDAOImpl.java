package model.DAO.Impl;

import model.DAO.Interfaces.WaypointDAO;
import model.Entities.Waypoint;
import org.hibernate.Session;

public class WaypointDAOImpl extends GenericDAOImpl  implements WaypointDAO {

    public WaypointDAOImpl(Session session) {
        super(Waypoint.class, session);
    }
}
