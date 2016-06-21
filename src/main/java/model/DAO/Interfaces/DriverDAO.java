package model.DAO.Interfaces;

import model.Entities.Driver;
import model.Entities.Order;

import java.util.List;

/**
 * The interface Driver dao.
 */
public interface DriverDAO {
    List<Driver> getFreeDrivers();

    Order getOrderByDriverId(int driverId);
}
