package services.Wagon;

import model.DAO.Impl.WagonDAOImpl;
import model.Entities.Wagon;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * The type Get all free and ready wagons.
 */
public class GetAllFreeAndReadyWagons {

    private static Logger logger = Logger.getLogger(GetAllFreeAndReadyWagons.class);

    /**
     * Gets all free and ready wagons.
     *
     * @param sessionFactory the session factory
     * @return the all free and ready wagons
     */
    public static List getAllFreeAndReadyWagons(SessionFactory sessionFactory) {
        logger.info("Trying to get all free wagons");
        Session session = null;
        List<Wagon> all = null;
        try {
            session = sessionFactory.openSession();
            WagonDAOImpl wagonDAO = new WagonDAOImpl(session);

            Transaction transaction = session.beginTransaction();
            all = wagonDAO.getAllReadyWagons();
            transaction.commit();

            if (!all.isEmpty()) {
                logger.info("List of free wagons successfully received");
            } else {
                logger.info("Free wagons list is empty");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return all;
    }
}
