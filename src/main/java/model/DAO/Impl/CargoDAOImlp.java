package model.DAO.Impl;

import model.DAO.Interfaces.CargoDAO;
import model.Entities.Cargo;
import org.hibernate.Session;

/**
 * The type Cargo dao imlp.
 */
public class CargoDAOImlp extends GenericDAOImpl implements CargoDAO {

    /**
     * Instantiates a new Cargo dao imlp.
     *
     * @param session the session
     */
    public CargoDAOImlp(Session session) {
        super(Cargo.class, session);
    }
}
