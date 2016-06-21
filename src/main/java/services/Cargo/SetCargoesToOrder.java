package services.Cargo;

import model.DAO.Impl.CargoDAOImlp;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public final class SetCargoesToOrder {

    private static Logger logger = Logger.getLogger(SetCargoesToOrder.class);

    private SetCargoesToOrder() {
    }


    public static void setCargoesToOrder(int[] addedCargoes, int id, SessionFactory sessionFactory) {
        logger.info("Trying to set all cargoes");
        Session session = null;
        try {
            session = sessionFactory.openSession();
            CargoDAOImlp cargoDAO = new CargoDAOImlp(session);
            cargoDAO.setToOrder(addedCargoes, id);
            Transaction transaction = session.beginTransaction();

            transaction.commit();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
