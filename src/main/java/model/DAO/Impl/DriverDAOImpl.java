package model.DAO.Impl;

import model.DAO.Interfaces.DriverDAO;
import model.Entities.Driver;
import org.hibernate.Session;

public class DriverDAOImpl extends GenericDAOImpl implements DriverDAO {

    public DriverDAOImpl(Session session) {
        super(Driver.class, session);
    }
}
