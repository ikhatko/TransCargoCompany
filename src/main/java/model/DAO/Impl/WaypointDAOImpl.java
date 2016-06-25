package model.DAO.Impl;

import model.DAO.Interfaces.WaypointDAO;
import model.Entities.Waypoint;
import org.hibernate.Session;

/**
 * The type Waypoint dao.
 */
public class WaypointDAOImpl extends GenericDAOImpl  implements WaypointDAO {

    /**
     * Instantiates a new Waypoint dao.
     *
     * @param session hibernate session
     */
    public WaypointDAOImpl(Session session) {
        super(Waypoint.class, session);
    }
}
