package services.Cargo;

import model.DAO.Impl.CargoDAOImlp;
import model.Entities.Cargo;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * The type Add new cargo.
 */
public class AddNewCargo {

    private static Logger logger = Logger.getLogger(AddNewCargo.class);

    /**
     * Add new cargo boolean.
     *
     * @param name           the name
     * @param weight         the weight
     * @param volume         the volume
     * @param sessionFactory the session factory
     * @return the boolean
     */
    public static boolean addNewCargo(String name, float weight, float volume,
                                      SessionFactory sessionFactory) {
        boolean result = false;
        Session session = null;
        Cargo cargo = null;
        logger.info("Adding new cargo:" + name);
        try {
            session = sessionFactory.openSession();
            CargoDAOImlp cargoDAO = new CargoDAOImlp(session);
            cargo = new Cargo(name, weight, volume);
            Transaction transaction = session.beginTransaction();
            cargoDAO.create(cargo);
            transaction.commit();
            result = true;
            logger.info("New cargo added successfully");
        } catch (Throwable e) {
            logger.info("New cargo doesn't added");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
