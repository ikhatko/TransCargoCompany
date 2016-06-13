package model.DAO.Impl;

import model.DAO.Interfaces.CargoDAO;
import model.Entities.Cargo;
import org.hibernate.Session;

public class CargoDAOImlp extends GenericDAOImpl implements CargoDAO {

    public CargoDAOImlp(Session session) {
        super(Cargo.class, session);
    }
}
