package model.Entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Order.
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private int orderId;

    private float maxWeight;

    private float maxVolume;

    private float routeDistance;

    private float routeDuration;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private OrderStatus orderStatus;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private Wagon orderWagon;

    @OneToMany(mappedBy = "waypointOrder", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<Waypoint> waypointList = new ArrayList<Waypoint>();

    @OneToMany(mappedBy = "currentOrder", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<Driver> driverSet = new ArrayList<>();

    @OneToMany(mappedBy = "cargoOrder", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private Set<Cargo> cargoSet = new HashSet<Cargo>();


    /**
     * Instantiates a new Order.
     */
    public Order() {
    }


    /**
     * Gets order id.
     *
     * @return the order id
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Sets order id.
     *
     * @param orderId the order id
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets order status.
     *
     * @return the order status
     */
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    /**
     * Sets order status.
     *
     * @param orderStatus the order status
     */
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Gets waypoint list.
     *
     * @return the waypoint list
     */
    public List<Waypoint> getWaypointList() {
        return waypointList;
    }

    /**
     * Sets waypoint list.
     *
     * @param waypointList the waypoint list
     */
    public void setWaypointList(List<Waypoint> waypointList) {
        this.waypointList = waypointList;
    }

    /**
     * Gets order wagon.
     *
     * @return the order wagon
     */
    public Wagon getOrderWagon() {
        return orderWagon;
    }

    /**
     * Sets order wagon.
     *
     * @param orderWagon the order wagon
     */
    public void setOrderWagon(Wagon orderWagon) {
        this.orderWagon = orderWagon;
    }

    /**
     * Gets driver set.
     *
     * @return the driver set
     */

    public void setCargoSet(Set<Cargo> cargoSet) {
        this.cargoSet = cargoSet;
    }

    public List<Driver> getDriverSet() {
        return driverSet;
    }

    public void setDriverSet(List<Driver> driverSet) {
        this.driverSet = driverSet;
    }

    public Set<Cargo> getCargoSet() {
        return cargoSet;
    }


    public float getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(float maxWeight) {
        this.maxWeight = maxWeight;
    }

    public float getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(float maxVolume) {
        this.maxVolume = maxVolume;
    }


    public float getRouteDistance() {
        return routeDistance;
    }

    public void setRouteDistance(float routeDistance) {
        this.routeDistance = routeDistance;
    }

    public float getRouteDuration() {
        return routeDuration;
    }

    public void setRouteDuration(float routeDuration) {
        this.routeDuration = routeDuration;
    }

    @Override
    public String toString() {
        return "" + orderId;
    }
}
