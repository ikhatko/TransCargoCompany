package model.DAO.Interfaces;

import model.Entities.Wagon;

import java.util.List;

/**
 * The interface Wagon dao.
 */
public interface WagonDAO {
    List<Wagon> getAllReadyWagons();
}
