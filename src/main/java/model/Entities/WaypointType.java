package model.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WaypointType {

    @Id
    @GeneratedValue
    private int waypointTypeId;

    @Column(nullable = false)
    private String waypointType;

    public WaypointType() {
    }

    @Override
    public String toString() {
        return waypointType;
    }

    public int getWaypointTypeId() {
        return waypointTypeId;
    }

    public void setWaypointTypeId(int cargoStatusId) {
        this.waypointTypeId = cargoStatusId;
    }

    public String getWaypointStatusName() {
        return waypointType;
    }

    public void setWaypointStatusName(String waypointStatusName) {
        this.waypointType = waypointStatusName;
    }
}
