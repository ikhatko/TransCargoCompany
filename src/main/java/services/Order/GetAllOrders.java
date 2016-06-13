package services.Order;

import model.DAO.Impl.OrderDAOImpl;
import model.Entities.Driver;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class GetAllOrders {

    private static Logger logger = Logger.getLogger(GetAllOrders.class);

    public static List getAllOrders(SessionFactory sessionFactory) {
        logger.info("Trying to get all orders");
        Session session = null;
        List<Driver> all = null;
        try {
            session = sessionFactory.openSession();
            OrderDAOImpl orderDAO = new OrderDAOImpl(session);

            Transaction transaction = session.beginTransaction();
            all = orderDAO.getAll();
            transaction.commit();

            if (!all.isEmpty()) {
                logger.info("List of orders successfully received");
            } else {
                logger.info("Order list is empty.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return all;
    }
}
