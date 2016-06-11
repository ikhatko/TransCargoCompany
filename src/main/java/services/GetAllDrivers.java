package services;

import model.DAO.Impl.DriverDAOImpl;
import model.Entities.Driver;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class GetAllDrivers {

    private static Logger logger = Logger.getLogger(GetAllDrivers.class);

    public static List getAllDrivers(SessionFactory sessionFactory) {
        logger.info("Trying to get all drivers");
        Session session = null;
        List all = null;
        try {
            session = sessionFactory.openSession();
            DriverDAOImpl driverDAO = new DriverDAOImpl(Driver.class, session);
            all = driverDAO.getAll();
            logger.info("All drivers get successfully");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return all;
    }
}
