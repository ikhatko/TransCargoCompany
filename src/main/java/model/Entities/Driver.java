package model.Entities;

import javax.persistence.*;

@Entity
public class Driver {
    @Id
    @GeneratedValue
    private int driverId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private double thisMonthHours;

    @ManyToOne
    private DriverStatus driverStatus;

    @ManyToOne
    private City currentCity;

    @ManyToOne
    private Wagon currentWagon;

    @ManyToOne
    @JoinColumn(name = "orderId",nullable = false)
    private Order currentOrder;

    public Driver() {
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getThisMonthHours() {
        return thisMonthHours;
    }

    public void setThisMonthHours(double thisMonthHours) {
        this.thisMonthHours = thisMonthHours;
    }

    public City getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    public Wagon getCurrentWagon() {
        return currentWagon;
    }

    public void setCurrentWagon(Wagon currentWagon) {
        this.currentWagon = currentWagon;
    }

    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }
}
