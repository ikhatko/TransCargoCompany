package services.Wagon;

import model.DAO.Impl.WagonDAOImpl;
import model.Entities.Wagon;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AddNewWagon {

    private static Logger logger = Logger.getLogger(AddNewWagon.class);

    public static boolean addNewWagon(String licensePlate, String driversChange, String maxWeight, String maxVolume, SessionFactory sessionFactory) {
        boolean result = false;
        Session session = null;
        Wagon wagon = null;
        logger.info("Adding new wagon:" + licensePlate);
        try {
            session = sessionFactory.openSession();
            WagonDAOImpl wagonDAO = new WagonDAOImpl(session);
            wagon = new Wagon();
            wagon.setLicensePlate(licensePlate);
            if (driversChange != null) {
                wagon.setDriversChange(Integer.parseInt(driversChange));
            } else {
                wagon.setDriversChange(1);
            }

            if (maxWeight != null) {
                wagon.setMaxWeight(Float.parseFloat(maxWeight));
            } else {
                wagon.setMaxWeight(0);
            }

            if (maxVolume != null) {
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
}
