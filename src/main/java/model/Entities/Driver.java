package model.Entities;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;

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
    @Cascade(CascadeType.PERSIST)
    private DriverStatus driverStatus;

    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    private City currentCity;

    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    private Wagon currentWagon;

    @ManyToOne
    @JoinColumn(name = "orderId")
    @Cascade(CascadeType.PERSIST)
    @Fetch (FetchMode.SELECT)
    private Order currentOrder;

    public Driver(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        thisMonthHours = 0;
        driverStatus = new DriverStatus();
        driverStatus.setDriverStatusId(1);
    }


    public Driver(String firstName, String lastName, double thisMonthHours, DriverStatus driverStatus, City currentCity, Wagon currentWagon, Order currentOrder) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.thisMonthHours = thisMonthHours;
        this.driverStatus = driverStatus;
        this.currentCity = currentCity;
        this.currentWagon = currentWagon;
        this.currentOrder = currentOrder;
    }

    public Driver() {
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
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
