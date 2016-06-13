package model.DAO.Impl;

import model.DAO.Interfaces.OrderDAO;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

public class OrderDAOImpl extends GenericDAOImpl  implements OrderDAO {

    public OrderDAOImpl(Session session) {
        super(Order.class, session);
    }
}
