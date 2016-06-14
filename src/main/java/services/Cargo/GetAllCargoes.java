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
public class GetAllCargoes {

    private static Logger logger = Logger.getLogger(GetAllCargoes.class);

    /**
     * Gets all cargoes.
     *
     * @param sessionFactory the session factory
     * @return the all cargoes
     */
    public static List getAllCargoes(SessionFactory sessionFactory) {
        logger.info("Trying to get all cargos.");
        Session session = null;
        List<Cargo> all = null;
        try {
            session = sessionFactory.openSession();
            CargoDAOImlp cargoDAO = new CargoDAOImlp(session);

            Transaction transaction = session.beginTransaction();
            all = cargoDAO.getAll();
            transaction.commit();

            if (!all.isEmpty()) {
                logger.info("List of cargoes successfully received");
            } else {
                logger.info("Cargoes list is empty.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return all;
    }
}
