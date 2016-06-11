package model.DAO.Impl;

import model.DAO.Interfaces.OrderDAO;
import org.hibernate.Session;

public class OrderDAOImpl extends GenericDAOImpl  implements OrderDAO {

    public OrderDAOImpl(Class entityType, Session session) {
        super(entityType, session);
    }
}
