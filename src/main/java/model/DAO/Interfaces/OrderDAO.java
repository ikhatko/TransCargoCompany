package model.DAO.Interfaces;

import model.Entities.Waypoint;

import java.util.List;

/**
 * The interface Order dao.
 */
public interface OrderDAO {

    List<Waypoint> getOrderWaypointsList(int orderId);
}
