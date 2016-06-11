package model.DAO.Impl;

import model.DAO.Interfaces.WagonDAO;
import org.hibernate.Session;

public class WaypointDAOImpl extends GenericDAOImpl  implements WagonDAO {

    public WaypointDAOImpl(Class entityType, Session session) {
        super(entityType, session);
    }
}
