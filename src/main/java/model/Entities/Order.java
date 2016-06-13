package model.Entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private int orderId;

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
    @Fetch (FetchMode.SELECT)
    private Set<Driver> driverSet = new HashSet<Driver>();

    public Order() {
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Waypoint> getWaypointList() {
        return waypointList;
    }

    public void setWaypointList(List<Waypoint> waypointList) {
        this.waypointList = waypointList;
    }

    public Wagon getOrderWagon() {
        return orderWagon;
    }

    public void setOrderWagon(Wagon orderWagon) {
        this.orderWagon = orderWagon;
    }

    public Set<Driver> getDriverSet() {
        return driverSet;
    }

    public void setDriverSet(Set<Driver> driverSet) {
        this.driverSet = driverSet;
    }

    @Override
    public String toString() {
        return "" + orderId;
    }
}
