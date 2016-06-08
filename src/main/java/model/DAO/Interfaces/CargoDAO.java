package model.DAO.Interfaces;

import model.Entities.Cargo;

public interface CargoDAO {
    Cargo getCargoById(int cargoId);
    void createCargo(Cargo cargo);
    void updateCargo(Cargo cargo);
    void deleteCargoById(int cargoId);
}
