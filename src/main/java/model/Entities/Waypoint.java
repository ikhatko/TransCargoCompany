package model.Entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

/**
 * The type Waypoint.
 */
@Entity
public class Waypoint {
    @Id
    @GeneratedValue
    private int waypointId;

    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    private City waypointCity;

    @ManyToOne
    @JoinColumn(name = "cargoId")
    @Cascade(CascadeType.PERSIST)
    private Cargo waypointCargo;

    @ManyToOne
    @JoinColumn(name = "orderId")
    @Cascade(CascadeType.PERSIST)
    private Order waypointOrder;

    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    private WaypointType waypointType;

    /**
     * Instantiates a new Waypoint.
     */
    public Waypoint() {
    }

    @Override
    public String toString() {
        return waypointCargo + " " + waypointCity + " " + waypointType.getWaypointStatusName() + "<br>";
    }

    /**
     * Instantiates a new Waypoint.
     *
     * @param waypointCargo the waypoint cargo
     * @param waypointType  the waypoint type
     * @param waypointCity  the waypoint city
     */
    public Waypoint(Cargo waypointCargo, WaypointType waypointType, City waypointCity) {
        this.waypointCargo = waypointCargo;
        this.waypointType = waypointType;
        this.waypointCity = waypointCity;
    }

    /**
     * Gets waypoint id.
     *
     * @return the waypoint id
     */
    public int getWaypointId() {
        return waypointId;
    }

    /**
     * Sets waypoint id.
     *
     * @param waypointId the waypoint id
     */
    public void setWaypointId(int waypointId) {
        this.waypointId = waypointId;
    }

    /**
     * Gets waypoint city.
     *
     * @return the waypoint city
     */
    public City getWaypointCity() {
        return waypointCity;
    }

    /**
     * Sets waypoint city.
     *
     * @param waypointCity the waypoint city
     */
    public void setWaypointCity(City waypointCity) {
        this.waypointCity = waypointCity;
    }

    /**
     * Gets waypoint cargo.
     *
     * @return the waypoint cargo
     */
    public Cargo getWaypointCargo() {
        return waypointCargo;
    }

    /**
     * Sets waypoint cargo.
     *
     * @param waypointCargo the waypoint cargo
     */
    public void setWaypointCargo(Cargo waypointCargo) {
        this.waypointCargo = waypointCargo;
    }

    /**
     * Gets waypoint order.
     *
     * @return the waypoint order
     */
    public Order getWaypointOrder() {
        return waypointOrder;
    }

    /**
     * Sets waypoint order.
     *
     * @param waypointOrder the waypoint order
     */
    public void setWaypointOrder(Order waypointOrder) {
        this.waypointOrder = waypointOrder;
    }

    /**
     * Gets waypoint type.
     *
     * @return the waypoint type
     */
    public WaypointType getWaypointType() {
        return waypointType;
    }

    /**
     * Sets waypoint type.
     *
     * @param waypointType the waypoint type
     */
    public void setWaypointType(WaypointType waypointType) {
        this.waypointType = waypointType;
    }
}
