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

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AddDriverToOrder {
    private static Logger logger = Logger.getLogger(AddDriverToOrder.class);

    public static void addDriverToOrder(String driver, String orderId,
                                        SessionFactory sessionFactory) {
        logger.info("Trying to add drivers to order id:" + orderId);
        Session session = null;
        try {
            session = sessionFactory.openSession();
            OrderDAOImpl orderDAO = new OrderDAOImpl(session);
            DriverDAOImpl driverDAO = new DriverDAOImpl(session);

            Transaction transaction = session.beginTransaction();

            Order order = (Order) orderDAO.read(Integer.parseInt(orderId));

            if (order.getOrderWagon().getDriversChange() == 1) {
                Driver orderDriver = (Driver) driverDAO.read(Integer.parseInt(driver));
                List<Driver> driverList = order.getDriverSet();
                for (Driver drivers : driverList) {
                    drivers.setCurrentOrder(null);
                    DriverStatus driverStatus = new DriverStatus();
                    driverStatus.setDriverStatusId(1);
                    drivers.setDriverStatus(driverStatus);
                }
                DriverStatus driverStatus = new DriverStatus();
                driverStatus.setDriverStatusId(3);
                orderDriver.setDriverStatus(driverStatus);
                orderDriver.setCurrentOrder(order);
            } else if (order.getOrderWagon().getDriversChange() == 2) {
                if (order.getDriverSet().size() <= 2) {
                    Driver orderDriver = (Driver) driverDAO.read(Integer.parseInt(driver));
                    DriverStatus driverStatus = new DriverStatus();
                    driverStatus.setDriverStatusId(3);
                    orderDriver.setDriverStatus(driverStatus);
                    orderDriver.setCurrentOrder(order);
                }
            }
            transaction.commit();

            logger.info("Drivers added successfully");

        } catch (HibernateException e) {
            logger.info("Error during adding drivers to order id:" + orderId);
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
