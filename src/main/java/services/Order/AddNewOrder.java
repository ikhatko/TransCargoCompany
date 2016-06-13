package services.Order;

import model.DAO.Impl.OrderDAOImpl;
import model.Entities.Order;
import model.Entities.OrderStatus;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AddNewOrder {

    private static Logger logger = Logger.getLogger(AddNewOrder.class);

    public static boolean addNewOrder(String orderStatusId, SessionFactory sessionFactory) {
        boolean result = false;
        Session session = null;
        Order order = null;
        logger.info("Adding new order:");
        try {
            session = sessionFactory.openSession();
            OrderDAOImpl orderDAO = new OrderDAOImpl(session);
            order = new Order();

            OrderStatus orderStatus = new OrderStatus();
            orderStatus.setOrderStatusId(Integer.parseInt(orderStatusId));
            order.setOrderStatus(orderStatus);

            Transaction transaction = session.beginTransaction();
            orderDAO.create(order);
            transaction.commit();
            result = true;
            logger.info("New order added successfully");
        } catch (Throwable e) {
            logger.info("New order doesn't added");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
