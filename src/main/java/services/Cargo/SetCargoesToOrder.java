package services.Cargo;

import model.DAO.Impl.CargoDAOImlp;
import model.DAO.Impl.OrderDAOImpl;
import model.Entities.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public final class SetCargoesToOrder {

    private static Logger logger = Logger.getLogger(SetCargoesToOrder.class);

    private SetCargoesToOrder() {
    }


    public static void setCargoesToOrder(int[] addedCargoes, int orderId, SessionFactory sessionFactory) {
        logger.info("Trying to add all cargoes");
        Session session = null;
        try {
            session = sessionFactory.openSession();
            CargoDAOImlp cargoDAO = new CargoDAOImlp(session);
            OrderDAOImpl orderDAO = new OrderDAOImpl(session);

            Transaction transaction = session.beginTransaction();
            Order order = (Order) orderDAO.read(orderId);
            Wagon orderWagon = order.getOrderWagon();
            if (orderWagon != null) {
                WagonStatus wagonStatus = new WagonStatus();
                wagonStatus.setWagonStatusId(1);
                orderWagon.setWagonStatus(wagonStatus);
                order.setOrderWagon(null);
            }
            List<Driver> driverSet = order.getDriverSet();
            if (!driverSet.isEmpty()) {
                for (Driver driver : driverSet) {
                    DriverStatus driverStatus = new DriverStatus();
                    driverStatus.setDriverStatusId(1);
                    driver.setDriverStatus(driverStatus);
                    driver.setCurrentOrder(null);
                }
            }
            cargoDAO.setToOrder(addedCargoes, orderId);

            transaction.commit();
            logger.info("All cargoes added successfully");

        } catch (Exception e) {
            logger.error("Cargoes doesn't addded");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
