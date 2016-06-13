package model.Entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@Entity
public class Waypoint {
    @Id
    @GeneratedValue
    private int waypointId;

    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    private City waypointCity;

    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    private Cargo waypointCargo;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    @Cascade(CascadeType.PERSIST)
    private Order waypointOrder;

    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    private WaypointType waypointType;

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

    public Order getWaypointOrder() {
        return waypointOrder;
    }

    public void setWaypointOrder(Order waypointOrder) {
        this.waypointOrder = waypointOrder;
    }

    public WaypointType getWaypointType() {
        return waypointType;
    }

    public void setWaypointType(WaypointType waypointType) {
        this.waypointType = waypointType;
    }
}
