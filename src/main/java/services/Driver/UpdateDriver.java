package services.Driver;

import model.DAO.Impl.DriverDAOImpl;
import model.Entities.*;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * The type Update driver.
 */
public class UpdateDriver {

    private static Logger logger = Logger.getLogger(UpdateDriver.class);

    /**
     * Update driver.
     *
     * @param id             the id
     * @param sessionFactory the session factory
     * @param firstName      the first name
     * @param lastName       the last name
     * @param hours          the hours
     * @param cityId         the city id
     * @param driverStatusId the driver status id
     * @param wagonId        the wagon id
     * @param orderId        the order id
     */
    public static void updateDriver(int id, SessionFactory sessionFactory, String firstName, String lastName,
                                    String hours, String cityId, String driverStatusId, String wagonId, String orderId) {
        logger.info("Trying to update Driver with id:" + id);
        Session session = null;

        try {
            session = sessionFactory.openSession();
            DriverDAOImpl driverDAO = new DriverDAOImpl(session);
            Driver driver = (Driver) driverDAO.read(id);

            driver.setFirstName(firstName);
            driver.setLastName(lastName);

            if (checkData(driverStatusId)) {
                DriverStatus driverStatus = new DriverStatus();
                driverStatus.setDriverStatusId(Integer.parseInt(driverStatusId));
                driver.setDriverStatus(driverStatus);
            }

            if (checkData(hours)) {
                driver.setThisMonthHours(Float.parseFloat(hours));
            }

            if (checkData(cityId)) {
                City city = new City();
                city.setCityId(Integer.parseInt(cityId));
                driver.setCurrentCity(city);
            }

            if (checkData(wagonId)) {
                Wagon wagon = new Wagon();
                wagon.setWagonId(Integer.parseInt(wagonId));
                driver.setCurrentWagon(wagon);
            }

            if (checkData(orderId)) {
                Order order = new Order();
                order.setOrderId(Integer.parseInt(orderId));
                driver.setCurrentOrder(order);
            } else {
                driver.setCurrentOrder(null);
            }

            Transaction transaction = session.beginTransaction();
            transaction.commit();

            logger.info("Driver with id:" + id + " updated successfully");

        } catch (HibernateException e) {
            logger.info("Driver with id:" + id + " doesn't updated");
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    private static boolean checkData(String data) {
        return data != null && !data.equals("null") && !data.equals("");
    }
}
