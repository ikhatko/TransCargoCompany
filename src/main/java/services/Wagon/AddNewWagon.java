package services.Wagon;

import model.DAO.Impl.WagonDAOImpl;
import model.Entities.City;
import model.Entities.Wagon;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * The type Add new wagon.
 */
public class AddNewWagon {

    private static Logger logger = Logger.getLogger(AddNewWagon.class);

    /**
     * Add new wagon boolean.
     *
     * @param licensePlate   the license plate
     * @param driversChange  the drivers change
     * @param maxWeight      the max weight
     * @param maxVolume      the max volume
     * @param currentCity    the current city
     * @param sessionFactory the session factory
     * @return the boolean
     */
    public static boolean addNewWagon(String licensePlate, String driversChange,
                                      String maxWeight, String maxVolume,
                                      String currentCity, SessionFactory sessionFactory) {
        logger.info("Adding new wagon:" + licensePlate);

        boolean result = false;
        Session session = null;
        Wagon wagon = null;

        try {
            session = sessionFactory.openSession();
            WagonDAOImpl wagonDAO = new WagonDAOImpl(session);
            wagon = new Wagon();
            wagon.setLicensePlate(licensePlate);
            if (checkData(driversChange)) {
                wagon.setDriversChange(Integer.parseInt(driversChange));
            } else {
                wagon.setDriversChange(1);
            }

            if (checkData(currentCity)) {
                City city = new City();
                city.setCityId(Integer.parseInt(currentCity));
                wagon.setCurrentCity(city);
            }

            if (checkData(maxWeight)) {
                wagon.setMaxWeight(Float.parseFloat(maxWeight));
            } else {
                wagon.setMaxWeight(0);
            }

            if (checkData(maxVolume)) {
                wagon.setMaxVolume(Float.parseFloat(maxVolume));
            } else {
                wagon.setMaxVolume(0);
            }

            Transaction transaction = session.beginTransaction();
            wagonDAO.create(wagon);
            transaction.commit();

            result = true;
            logger.info("New wagon added successfully");

        } catch (Throwable e) {
            logger.info("New wagon doesn't added");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
    private static boolean checkData(String data) {
        return data != null && !data.equals("null") && !data.equals("");
    }
}
