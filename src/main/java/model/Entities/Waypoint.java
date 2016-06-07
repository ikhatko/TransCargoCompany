package model.Entities;

import javax.persistence.*;

@Entity
public class Waypoint {
    @Id
    @GeneratedValue
    private int waypointId;

    @ManyToOne
    private City waypointCity;

    @ManyToOne
    private Cargo waypointCargo;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    private Order waypointOrder;

    @Column(nullable = false)
    private WaypointType waypointType;

    public enum WaypointType {
        LOADING, UNLOADING
    }

    public Waypoint() {
    }

    public int getWaypointId() {
        return waypointId;
    }

    public void setWaypointId(int waypointId) {
        this.waypointId = waypointId;
    }

    public City getWaypointCity() {
        return waypointCity;
    }

    public void setWaypointCity(City waypointCity) {
        this.waypointCity = waypointCity;
    }

    public Cargo getWaypointCargo() {
        return waypointCargo;
    }

    public void setWaypointCargo(Cargo waypointCargo) {
        this.waypointCargo = waypointCargo;
    }

    public WaypointType getWaypointType() {
        return waypointType;
    }

    public void setWaypointType(WaypointType waypointType) {
        this.waypointType = waypointType;
    }
}
