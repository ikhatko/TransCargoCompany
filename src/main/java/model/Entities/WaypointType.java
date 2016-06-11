package model.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WaypointType {

    @Id
    @GeneratedValue
    private int cargoStatusId;

    @Column(nullable = false)
    private String waypointType;

    public WaypointType() {
    }

    public int getCargoStatusId() {
        return cargoStatusId;
    }

    public void setCargoStatusId(int cargoStatusId) {
        this.cargoStatusId = cargoStatusId;
    }

    public String getWaypointStatusName() {
        return waypointType;
    }

    public void setWaypointStatusName(String waypointStatusName) {
        this.waypointType = waypointStatusName;
    }
}
