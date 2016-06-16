package model.DAO.Interfaces;

import model.Entities.Cargo;

import java.util.List;

/**
 * The interface Cargo dao.
 */
public interface CargoDAO {

    List<Cargo> getFreeCargoes();

    void setToOrder(int[] array, int orderId);
}
