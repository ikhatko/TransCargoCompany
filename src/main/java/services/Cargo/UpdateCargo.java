package services.Cargo;

import model.DAO.Impl.CargoDAOImlp;
import model.Entities.Cargo;
import model.Entities.CargoStatus;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * The type Update cargo.
 */
public class UpdateCargo {

    private static Logger logger = Logger.getLogger(UpdateCargo.class);

    /**
     * Update cargo.
     *
     * @param id             the id
     * @param name           the name
     * @param weight         the weight
     * @param volume         the volume
     * @param cargoStatusId  the cargo status id
     * @param sessionFactory the session factory
     */
    public static void updateCargo(int id, String name, String weight, String volume,
                                    String cargoStatusId, SessionFactory sessionFactory) {
        logger.info("Trying to update Cargo with id:" + id);
        Session session = null;

        try {
            session = sessionFactory.openSession();
            CargoDAOImlp cargoDAO = new CargoDAOImlp(session);
            Cargo cargo = (Cargo) cargoDAO.read(id);

            cargo.setName(name);
            cargo.setWeight(Float.parseFloat(weight));
            cargo.setVolume(Float.parseFloat(volume));

            if (cargoStatusId != null && !cargoStatusId.equals("null") && !cargoStatusId.equals("")) {
                CargoStatus cargoStatus = new CargoStatus();
                cargoStatus.setCargoStatusId(Integer.parseInt(cargoStatusId));
                cargo.setCargoStatus(cargoStatus);
            }

            Transaction transaction = session.beginTransaction();
            transaction.commit();

            logger.info("Cargo with id:" + id + " updated successfully");

        } catch (HibernateException e) {
            logger.info("Cargo with id:" + id + " doesn't updated");
            e.printStackTrace();
        } finally {
            session.close();
        }


    }
}
