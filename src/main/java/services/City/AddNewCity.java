package services.City;

import model.DAO.Impl.CityDAOImpl;
import model.Entities.City;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * The type Add new city.
 */
public class AddNewCity {

    private static Logger logger = Logger.getLogger(AddNewCity.class);

    /**
     * Add new city boolean.
     *
     * @param cityName       the city name
     * @param sessionFactory the session factory
     * @return the boolean
     */
    public static boolean addNewCity(String cityName,
                                     SessionFactory sessionFactory) {
        boolean result = false;
        Session session = null;
        City city = null;
        logger.info("Adding new city:" + cityName);
        try {
            session = sessionFactory.openSession();
            CityDAOImpl cityDAO = new CityDAOImpl(session);
            city = new City(cityName);
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
