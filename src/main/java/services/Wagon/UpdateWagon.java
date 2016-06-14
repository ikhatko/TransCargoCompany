package services.Wagon;

import model.DAO.Impl.WagonDAOImpl;
import model.Entities.*;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * The type Update wagon.
 */
public class UpdateWagon {

    private static Logger logger = Logger.getLogger(UpdateWagon.class);

    /**
     * Update wagon.
     *
     * @param id             the id
     * @param licensePlate   the license plate
     * @param driversChange  the drivers change
     * @param maxWeight      the max weight
     * @param maxVolume      the max volume
     * @param currentCityId  the current city id
     * @param wagonStatusId  the wagon status id
     * @param sessionFactory the session factory
     */
    public static void updateWagon(int id, String licensePlate, String driversChange, String maxWeight,
                                   String maxVolume, String currentCityId, String wagonStatusId, SessionFactory sessionFactory) {
        logger.info("Trying to update Wagon with id:" + id);
        Session session = null;

        try {
            session = sessionFactory.openSession();
            WagonDAOImpl wagonDAO = new WagonDAOImpl(session);
            Wagon wagon = (Wagon) wagonDAO.read(id);

            wagon.setLicensePlate(licensePlate);
            if (maxWeight != null && !maxWeight.equals("")) {
                wagon.setMaxWeight(Float.parseFloat(maxWeight));
            }
            if (maxVolume != null && !maxVolume.equals("")) {
                wagon.setMaxWeight(Float.parseFloat(maxVolume));
            }
            if (driversChange != null) {
                wagon.setDriversChange(Integer.parseInt(driversChange));
            }

            if (currentCityId != null && !currentCityId.equals("null") && !currentCityId.equals("")) {
                City city = new City();
                city.setCityId(Integer.parseInt(currentCityId));
                wagon.setCurrentCity(city);
            } else {
                wagon.setCurrentCity(null);
            }

            if (wagonStatusId != null) {
                WagonStatus wagonStatus = new WagonStatus();
                wagonStatus.setWagonStatusId(Integer.parseInt(wagonStatusId));
                wagon.setWagonStatus(wagonStatus);
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
