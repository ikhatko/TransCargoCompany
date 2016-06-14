package model.DAO.Impl;

import model.DAO.Interfaces.DriverDAO;
import model.Entities.Driver;
import org.hibernate.Session;

/**
 * The type Driver dao.
 */
public class DriverDAOImpl extends GenericDAOImpl implements DriverDAO {

    /**
     * Instantiates a new Driver dao.
     *
     * @param session the session
     */
    public DriverDAOImpl(Session session) {
        super(Driver.class, session);
    }
}
