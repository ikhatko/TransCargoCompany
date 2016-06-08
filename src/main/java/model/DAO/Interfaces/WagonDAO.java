package model.DAO.Interfaces;

import model.Entities.Wagon;

public interface WagonDAO {
    Wagon getWagonById(int wagonId);
    void createWagon(Wagon wagon);
    void updateWagon(Wagon wagon);
    void deleteWagonById(int wagonId);
}
