package services.Wagon;

import model.DAO.Impl.WagonDAOImpl;
import model.Entities.*;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UpdateWagon {

    private static Logger logger = Logger.getLogger(UpdateWagon.class);

    public static void updateWagon(int id, String licensePlate, int driversChange, float maxWeight,
                                   float maxVolume, String currentCityId, String wagonStatusId, SessionFactory sessionFactory) {
        logger.info("Trying to update Wagon with id:" + id);
        Session session = null;

        try {
            session = sessionFactory.openSession();
            WagonDAOImpl wagonDAO = new WagonDAOImpl(session);
            Wagon wagon = (Wagon) wagonDAO.read(id);

            wagon.setLicensePlate(licensePlate);
            wagon.setDriversChange(driversChange);
            wagon.setMaxWeight(maxWeight);
            wagon.setMaxVolume(maxVolume);

            if (currentCityId != null && !currentCityId.equals("null") && !currentCityId.equals("")) {
                City city = new City();
                city.setCityId(Integer.parseInt(currentCityId));
                wagon.setCurrentCity(city);
            } else {
                wagon.setCurrentCity(null);
            }

            if (wagonStatusId != null && !wagonStatusId.equals("null") && !wagonStatusId.equals("")) {
                WagonStatus wagonStatus = new WagonStatus();
                wagonStatus.setWagonStatusId(Integer.parseInt(wagonStatusId));
                wagon.setWagonStatus(wagonStatus);
            } else {
                wagon.setWagonStatus(null);
            }

            Transaction transaction = session.beginTransaction();
            transaction.commit();

            logger.info("Wagon with id:" + id + " updated successfully");

        } catch (HibernateException e) {
            logger.info("Wagon with id:" + id + " doesn't updated");
            e.printStackTrace();
        } finally {
            session.close();
        }


    }
}
