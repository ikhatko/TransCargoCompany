package services.Cargo;

import model.DAO.Impl.CargoDAOImlp;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class RemoveCargo {

    private static Logger logger = Logger.getLogger(RemoveCargo.class);

    public static void removeCargo(int id, SessionFactory sessionFactory) {
        logger.info("Removing cargo with id:" + id);

        Session session = null;
        try {
            session = sessionFactory.openSession();
            CargoDAOImlp cargoDAO = new CargoDAOImlp(session);

            Transaction transaction = session.beginTransaction();
            cargoDAO.delete(id);
            transaction.commit();

            logger.info("Cargo removed successfully");

        } catch (HibernateException e) {
            logger.info("Error during removing cargo id:" + id);
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}
