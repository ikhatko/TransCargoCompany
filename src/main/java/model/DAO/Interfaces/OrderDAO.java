package model.DAO.Interfaces;

import model.Entities.Order;
import model.Entities.Waypoint;

import java.util.List;

/**
 * The interface Order dao.
 */
public interface OrderDAO {

    /**
     * Gets order waypoints list.
     *
     * @param orderId the order id
     * @return the order waypoints list
     */
    List<Waypoint> getOrderWaypointsList(int orderId);
}
