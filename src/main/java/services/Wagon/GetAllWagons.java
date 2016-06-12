package services.Wagon;

import model.DAO.Impl.WagonDAOImpl;
import model.Entities.Wagon;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class GetAllWagons {

    private static Logger logger = Logger.getLogger(GetAllWagons.class);

    public static List getAllWagons(SessionFactory sessionFactory) {
        logger.info("Trying to get all wagons");
        Session session = null;
        List<Wagon> all = null;
        try {
            session = sessionFactory.openSession();
            WagonDAOImpl wagonDAO = new WagonDAOImpl(session);

            Transaction transaction = session.beginTransaction();
            all = wagonDAO.getAll();
            transaction.commit();

            if (!all.isEmpty()) {
                logger.info("List of wagons successfully received");
            } else {
                logger.info("Wagons list is empty");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return all;
    }
}
