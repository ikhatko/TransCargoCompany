package model.DAO.Interfaces;

import model.Entities.Wagon;

import java.util.List;

/**
 * The interface Wagon dao.
 */
public interface WagonDAO {
    /**
     * Gets all ready wagons.
     *
     * @return the all ready wagons
     */
    List<Wagon> getAllReadyWagons();
}
