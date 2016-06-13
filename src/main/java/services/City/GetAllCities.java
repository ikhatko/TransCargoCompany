package services.City;

import model.DAO.Impl.CityDAOImpl;
import model.Entities.City;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class GetAllCities {

    private static Logger logger = Logger.getLogger(GetAllCities.class);

    public static List getAllCities(SessionFactory sessionFactory) {
        logger.info("Trying to get all cities");
        Session session = null;
        List<City> all = null;
        try {
            session = sessionFactory.openSession();
            CityDAOImpl cityDAO = new CityDAOImpl(session);

            Transaction transaction = session.beginTransaction();
            all = cityDAO.getAll();
            transaction.commit();
            if (!all.isEmpty()) {
                logger.info("List of cities successfully received");
            } else {
                logger.info("Cities list is empty.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return all;
    }
}
