package model.DAO.Interfaces;

import model.Entities.Driver;
import model.Entities.Order;

import java.util.List;

/**
 * The interface Driver dao.
 */
public interface DriverDAO {
    /**
     * Gets free drivers.
     *
     * @return the free drivers
     */
    List<Driver> getFreeDrivers();

    /**
     * Gets order by driver id.
     *
     * @param driverId the driver id
     * @return the order by driver id
     */
    Order getOrderByDriverId(int driverId);
}
