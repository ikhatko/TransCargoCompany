package services.City;

import model.DAO.Impl.CityDAOImpl;
import model.Entities.City;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UpdateCity {

    private static Logger logger = Logger.getLogger(UpdateCity.class);

    public static void updateCity(int id, String cityName, String distance, SessionFactory sessionFactory) {

        logger.info("Trying to update city with id:" + id);
        Session session = null;

        try {
            session = sessionFactory.openSession();
            CityDAOImpl cityDAO = new CityDAOImpl(session);
            City city = (City) cityDAO.read(id);

            city.setCityName(cityName);
            if (distance != null && !distance.equals("")) {
                city.setDistance(Long.parseLong(distance));
            }
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
