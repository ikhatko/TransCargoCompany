package model.DAO.Impl;

import model.DAO.Interfaces.WagonDAO;
import org.hibernate.Session;

public class WagonDAOImpl extends GenericDAOImpl  implements WagonDAO {

    public WagonDAOImpl(Class entityType, Session session) {
        super(entityType, session);
    }
}
