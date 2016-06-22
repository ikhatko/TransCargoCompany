package services.City;

import model.DAO.Impl.CityDAOImpl;
import model.Entities.City;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * The type Update city.
 */
public class UpdateCity {

    private static Logger logger = Logger.getLogger(UpdateCity.class);

    /**
     * Update city.
     *
     * @param id             the id
     * @param cityName       the city name
     * @param sessionFactory the session factory
     */
    public static void updateCity(int id, String cityName, SessionFactory sessionFactory) {

        logger.info("Trying to update city with id:" + id);
        Session session = null;

        try {
            session = sessionFactory.openSession();
            CityDAOImpl cityDAO = new CityDAOImpl(session);
            City city = (City) cityDAO.read(id);

            city.setCityName(cityName);

            Transaction transaction = session.beginTransaction();
            transaction.commit();

            logger.info("City with id:" + id + " updated successfully");

        } catch (HibernateException e) {
            logger.info("City with id:" + id + " doesn't updated");
            e.printStackTrace();
        } finally {
            session.close();
        }


    }
}
