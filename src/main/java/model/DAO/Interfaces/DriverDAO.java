package model.DAO.Interfaces;

import model.Entities.Driver;

public interface DriverDAO {
    Driver getDriverById(int driverId);
    void createDriver(Driver driver);
    void updateDriver(Driver driver);
    void deleteDriverById(int driverId);
}
