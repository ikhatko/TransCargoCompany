package services.Order;

import model.DAO.Impl.DriverDAOImpl;
import model.DAO.Impl.OrderDAOImpl;
import model.Entities.Driver;
import model.Entities.DriverStatus;
import model.Entities.Order;
import model.Entities.Wagon;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AddDriverToOrder {
    public static final int SINGLE = 1;
    public static final int DOUBLE = 2;
    public static final int DRIVER_STATUS_REST = 1;
    public static final int DRIVER_STATUS_RELAY = 3;

    private static Logger logger = Logger.getLogger(AddDriverToOrder.class);

    public static boolean addDriverToOrder(String driver, String orderId,
                                        SessionFactory sessionFactory) {

        logger.info("Trying to add drivers to order id:" + orderId);

        boolean result = false;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            OrderDAOImpl orderDAO = new OrderDAOImpl(session);
            DriverDAOImpl driverDAO = new DriverDAOImpl(session);

            Transaction transaction = session.beginTransaction();

            Order order = (Order) orderDAO.read(Integer.parseInt(orderId));

            Wagon orderWagon = order.getOrderWagon();

            if (orderWagon != null) {
                if (orderWagon.getDriversChange() == SINGLE) {
                    Driver orderDriver = (Driver) driverDAO.read(Integer.parseInt(driver));
                    List<Driver> driverList = order.getDriverSet();
                    for (Driver drivers : driverList) {
                        drivers.setCurrentOrder(null);
                        DriverStatus driverStatus = new DriverStatus();
                        driverStatus.setDriverStatusId(DRIVER_STATUS_REST);
                        drivers.setDriverStatus(driverStatus);
                    }
                    DriverStatus driverStatus = new DriverStatus();
                    driverStatus.setDriverStatusId(DRIVER_STATUS_RELAY);
                    orderDriver.setDriverStatus(driverStatus);
                    orderDriver.setCurrentOrder(order);
                } else if (orderWagon.getDriversChange() == DOUBLE) {
                    if (order.getDriverSet().size() < DOUBLE) {
                        Driver orderDriver = (Driver) driverDAO.read(Integer.parseInt(driver));
                        DriverStatus driverStatus = new DriverStatus();
                        driverStatus.setDriverStatusId(DRIVER_STATUS_RELAY);
                        orderDriver.setDriverStatus(driverStatus);
                        orderDriver.setCurrentOrder(order);
                    }
                }
                result = true;
            }

            transaction.commit();

            logger.info("Drivers added successfully");

        } catch (HibernateException e) {
            logger.error("Error during adding drivers to order id:" + orderId);
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
