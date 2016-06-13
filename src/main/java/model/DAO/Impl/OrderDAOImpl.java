package model.DAO.Impl;

import model.DAO.Interfaces.OrderDAO;
import model.Entities.Order;
import org.hibernate.Session;

public class OrderDAOImpl extends GenericDAOImpl  implements OrderDAO {

    public OrderDAOImpl(Session session) {
        super(Order.class, session);
    }
}
