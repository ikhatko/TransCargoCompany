package model.DAO.Impl;

import model.DAO.Interfaces.DriverDAO;
import model.Entities.Driver;
import model.Entities.Order;
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
     * @param session hibernate session
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

    @Override
    public Order getOrderByDriverId(int driverId) {
        Order order = null;
        Query query = session.createQuery("select currentOrder from Driver where driver_id = :driverId");
        query.setParameter("driverId", driverId);
        order = (Order) query.uniqueResult();
        return order;
    }
}
