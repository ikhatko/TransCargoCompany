package model.DAO.Interfaces;

import model.Entities.Cargo;

import java.util.List;

/**
 * The interface Cargo dao.
 */
public interface CargoDAO {

    /**
     * Gets free cargoes.
     *
     * @return the free cargoes
     */
    List<Cargo> getFreeCargoes();

    /**
     * Sets to order.
     *
     * @param array   the array
     * @param orderId the order id
     */
    void setToOrder(int[] array, int orderId);
}
