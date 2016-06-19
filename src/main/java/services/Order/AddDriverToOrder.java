package services.Order;

import model.DAO.Impl.DriverDAOImpl;
import model.DAO.Impl.OrderDAOImpl;
import model.Entities.Driver;
import model.Entities.DriverStatus;
import model.Entities.Order;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AddDriverToOrder {
    private static Logger logger = Logger.getLogger(AddDriverToOrder.class);

    public static void addDriverToOrder(String driver, String orderId,
                                        SessionFactory sessionFactory) {
        logger.info("Trying to add driver id: " + driver + " to order id:" + orderId);
        Session session = null;
        try {
            session = sessionFactory.openSession();
            OrderDAOImpl orderDAO = new OrderDAOImpl(session);
            DriverDAOImpl wagonDAO = new DriverDAOImpl(session);

            Transaction transaction = session.beginTransaction();
            Order order = (Order) orderDAO.read(Integer.parseInt(orderId));
            Driver orderDriver = (Driver) wagonDAO.read(Integer.parseInt(driver));
            DriverStatus driverStatus = new DriverStatus();
            driverStatus.setDriverStatusId(3);
            orderDriver.setDriverStatus(driverStatus);
            orderDriver.setCurrentOrder(order);
            transaction.commit();

            logger.info("Driver added successfully");

        } catch (HibernateException e) {
            logger.info("Error during adding driver id:" + driver + "to order id:" + orderId);
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
