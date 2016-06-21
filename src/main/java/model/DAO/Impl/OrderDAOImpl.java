package model.DAO.Impl;

import model.DAO.Interfaces.OrderDAO;
import model.Entities.Order;
import model.Entities.Waypoint;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * The type Order dao.
 */
public class OrderDAOImpl extends GenericDAOImpl implements OrderDAO {

    private Session session;

    /**
     * Instantiates a new Order dao.
     *
     * @param session the session
     */
    public OrderDAOImpl(Session session) {
        super(Order.class, session);
        this.session = session;
    }

    @Override
    public List<Waypoint> getOrderWaypointsList(int orderId) {
        List list = null;
        Order order = (Order) super.read(orderId);
        list = order.getWaypointList();
        return list;
    }

}
