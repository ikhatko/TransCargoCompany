package model.DAO.Impl;

import model.DAO.Interfaces.CargoDAO;
import model.Entities.Cargo;
import model.Entities.Order;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * The type Cargo dao imlp.
 */
public class CargoDAOImlp extends GenericDAOImpl implements CargoDAO {

    private Session session;

    /**
     * Instantiates a new Cargo dao imlp.
     *
     * @param session the session
     */
    public CargoDAOImlp(final Session session) {
        super(Cargo.class, session);
        this.session = session;
    }

    public List<Cargo> getFreeCargoes() {
        List list = null;
        Query query = session.createQuery("from Cargo where cargoOrder = null");
        list = query.list();
        return list;
    }

    public void setToOrder(int[] array, int orderId) {
        for (int i : array) {
            Cargo cargo = (Cargo) super.read(i);
            Order order = new Order();
            order.setOrderId(orderId);
            cargo.setCargoOrder(order);
        }
    }
}
