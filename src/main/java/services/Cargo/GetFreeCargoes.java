package services.Cargo;

import model.DAO.Impl.CargoDAOImlp;
import model.Entities.Cargo;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * The type Get all cargoes.
 */
public final class GetFreeCargoes {

    private static Logger logger = Logger.getLogger(GetFreeCargoes.class);

    private GetFreeCargoes() {
    }

    /**
     * Gets all cargoes.
     *
     * @param sessionFactory the session factory
     * @return the all cargoes
     */
    public static List getFreeCargoes(SessionFactory sessionFactory) {
        logger.info("Trying to get all free cargoes.");
        Session session = null;
        List<Cargo> all = null;
        try {
            session = sessionFactory.openSession();
            CargoDAOImlp cargoDAO = new CargoDAOImlp(session);

            Transaction transaction = session.beginTransaction();
            all = cargoDAO.getFreeCargoes();
            transaction.commit();

            if (!all.isEmpty()) {
                logger.info("List of free cargoes successfully received");
            } else {
                logger.info("Free cargoes list is empty.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return all;
    }
}
