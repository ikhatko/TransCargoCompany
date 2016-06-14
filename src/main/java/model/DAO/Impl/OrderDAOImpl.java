package model.DAO.Impl;

import model.DAO.Interfaces.OrderDAO;
import model.Entities.Order;
import org.hibernate.Session;

/**
 * The type Order dao.
 */
public class OrderDAOImpl extends GenericDAOImpl  implements OrderDAO {

    /**
     * Instantiates a new Order dao.
     *
     * @param session the session
     */
    public OrderDAOImpl(Session session) {
        super(Order.class, session);
    }
}
