package services.City;

import model.DAO.Impl.CityDAOImpl;
import model.Entities.City;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AddNewCity {

    private static Logger logger = Logger.getLogger(AddNewCity.class);

    public static boolean addNewCity(String cityName, String distance, SessionFactory sessionFactory) {
        boolean result = false;
        Session session = null;
        City city = null;
        logger.info("Adding new city:" + cityName);
        try {
            session = sessionFactory.openSession();
            CityDAOImpl cityDAO = new CityDAOImpl(session);
            city = new City(cityName, Long.parseLong(distance));
            Transaction transaction = session.beginTransaction();
            cityDAO.create(city);
            transaction.commit();
            result = true;
            logger.info("New city added successfully");
        } catch (Throwable e) {
            logger.info("New city doesn't added");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
