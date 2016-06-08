package model.DAO.Impl;

import model.DAO.Interfaces.CargoDAO;
import model.Entities.Cargo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CargoDAOImlp implements CargoDAO {

    private SessionFactory sessionFactory;

    public CargoDAOImlp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Cargo getCargoById(int cargoId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Cargo cargo = (Cargo) session.get(Cargo.class, cargoId);
        transaction.commit();
        session.close();
        return cargo;
    }

    public void createCargo(Cargo cargo) {

    }

    public void updateCargo(Cargo cargo) {

    }

    public void deleteCargoById(int cargoId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Cargo cargo = getCargoById(cargoId);
        session.delete(cargo);
        transaction.commit();
        session.close();
    }
}
