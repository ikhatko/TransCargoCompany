package model.Entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.*;

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
     * Sets cargo set.
     *
     * @param cargoSet the cargo set
     */
    public void setCargoSet(Set<Cargo> cargoSet) {
        this.cargoSet = cargoSet;
    }

    /**
     * Gets driver set.
     *
     * @return the driver set
     */
    public List<Driver> getDriverSet() {
        return driverSet;
    }

    /**
     * Sets driver set.
     *
     * @param driverSet the driver set
     */
    public void setDriverSet(List<Driver> driverSet) {
        this.driverSet = driverSet;
    }

    /**
     * Gets cargo set.
     *
     * @return the cargo set
     */
    public Set<Cargo> getCargoSet() {
        return cargoSet;
    }


    /**
     * Gets max weight.
     *
     * @return the max weight
     */
    public float getMaxWeight() {
        return maxWeight;
    }

    /**
     * Sets max weight.
     *
     * @param maxWeight the max weight
     */
    public void setMaxWeight(float maxWeight) {
        this.maxWeight = maxWeight;
    }

    /**
     * Gets max volume.
     *
     * @return the max volume
     */
    public float getMaxVolume() {
        return maxVolume;
    }

    /**
     * Sets max volume.
     *
     * @param maxVolume the max volume
     */
    public void setMaxVolume(float maxVolume) {
        this.maxVolume = maxVolume;
    }


    /**
     * Gets route distance.
     *
     * @return the route distance
     */
    public float getRouteDistance() {
        return routeDistance;
    }

    /**
     * Sets route distance.
     *
     * @param routeDistance the route distance
     */
    public void setRouteDistance(float routeDistance) {
        this.routeDistance = routeDistance;
    }

    /**
     * Gets route duration.
     *
     * @return the route duration
     */
    public float getRouteDuration() {
        return routeDuration;
    }

    /**
     * Sets route duration.
     *
     * @param routeDuration the route duration
     */
    public void setRouteDuration(float routeDuration) {
        this.routeDuration = routeDuration;
    }

    @Override
    public String toString() {
        return "" + orderId;
    }
}
