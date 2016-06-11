package model.DAO.Impl;

import model.DAO.Interfaces.DriverDAO;
import org.hibernate.Session;

public class DriverDAOImpl extends GenericDAOImpl implements DriverDAO {

    public DriverDAOImpl(Class entityType, Session session) {
        super(entityType, session);
    }
}
