package model.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The type Waypoint type.
 */
@Entity
public class WaypointType {

    @Id
    @GeneratedValue
    private int waypointTypeId;

    @Column(nullable = false)
    private String waypointType;

    /**
     * Instantiates a new Waypoint type.
     */
    public WaypointType() {
    }

    @Override
    public String toString() {
        return waypointType;
    }

    /**
     * Gets waypoint type id.
     *
     * @return the waypoint type id
     */
    public int getWaypointTypeId() {
        return waypointTypeId;
    }

    /**
     * Sets waypoint type id.
     *
     * @param cargoStatusId the cargo status id
     */
    public void setWaypointTypeId(int cargoStatusId) {
        this.waypointTypeId = cargoStatusId;
    }

    /**
     * Gets waypoint status name.
     *
     * @return the waypoint status name
     */
    public String getWaypointStatusName() {
        return waypointType;
    }

    /**
     * Sets waypoint status name.
     *
     * @param waypointStatusName the waypoint status name
     */
    public void setWaypointStatusName(String waypointStatusName) {
        this.waypointType = waypointStatusName;
    }
}
