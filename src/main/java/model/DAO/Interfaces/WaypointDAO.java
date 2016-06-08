package model.DAO.Interfaces;

import model.Entities.Waypoint;

public interface WaypointDAO {
    Waypoint getWaypointById(int waypointId);
    void createWaypoint(Waypoint waypoint);
    void updateWaypoint(Waypoint waypoint);
    void deleteWaypointById(int waypointId);
}
