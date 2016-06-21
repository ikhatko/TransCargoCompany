package model.DAO.Impl;

import model.DAO.Interfaces.DriverDAO;
import model.Entities.Driver;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * The type Driver dao.
 */
public class DriverDAOImpl extends GenericDAOImpl implements DriverDAO {

    private Session session;
    /**
     * Instantiates a new Driver dao.
     *
     * @param session the session
     */
    public DriverDAOImpl(Session session) {
        super(Driver.class, session);
        this.session = session;
    }

    @Override
    public List<Driver> getFreeDrivers() {
        List list = null;
        Query query = session.createQuery("from Driver where driverStatus = 1");
        list = query.list();
        return list;
    }
}
