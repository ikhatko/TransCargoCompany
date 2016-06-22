package model.Entities;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * The type Driver.
 */
@Entity
public class Driver {
    @Id
    @GeneratedValue
    private int driverId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private float thisMonthHours;

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
    @Fetch(FetchMode.SELECT)
    private Order currentOrder;

    /**
     * Instantiates a new Driver.
     *
     * @param firstName the first name
     * @param lastName  the last name
     */
    public Driver(String firstName, String lastName, City currentCity) {
        this.firstName = firstName;
        this.lastName = lastName;
        thisMonthHours = 0;
        driverStatus = new DriverStatus();
        driverStatus.setDriverStatusId(1);
        this.currentCity = currentCity;
    }


    /**
     * Instantiates a new Driver.
     *
     * @param firstName      the first name
     * @param lastName       the last name
     * @param thisMonthHours the this month hours
     * @param driverStatus   the driver status
     * @param currentCity    the current city
     * @param currentWagon   the current wagon
     * @param currentOrder   the current order
     */
    public Driver(String firstName, String lastName, float thisMonthHours, DriverStatus driverStatus, City currentCity, Wagon currentWagon, Order currentOrder) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.thisMonthHours = thisMonthHours;
        this.driverStatus = driverStatus;
        this.currentCity = currentCity;
        this.currentWagon = currentWagon;
        this.currentOrder = currentOrder;
    }

    /**
     * Instantiates a new Driver.
     */
    public Driver() {
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    /**
     * Gets driver id.
     *
     * @return the driver id
     */
    public int getDriverId() {
        return driverId;
    }

    /**
     * Sets driver id.
     *
     * @param driverId the driver id
     */
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets this month hours.
     *
     * @return the this month hours
     */
    public float getThisMonthHours() {
        return thisMonthHours;
    }

    /**
     * Sets this month hours.
     *
     * @param thisMonthHours the this month hours
     */
    public void setThisMonthHours(float thisMonthHours) {
        this.thisMonthHours = thisMonthHours;
    }

    /**
     * Gets current city.
     *
     * @return the current city
     */
    public City getCurrentCity() {
        return currentCity;
    }

    /**
     * Sets current city.
     *
     * @param currentCity the current city
     */
    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    /**
     * Gets current wagon.
     *
     * @return the current wagon
     */
    public Wagon getCurrentWagon() {
        return currentWagon;
    }

    /**
     * Sets current wagon.
     *
     * @param currentWagon the current wagon
     */
    public void setCurrentWagon(Wagon currentWagon) {
        this.currentWagon = currentWagon;
    }

    /**
     * Gets driver status.
     *
     * @return the driver status
     */
    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    /**
     * Sets driver status.
     *
     * @param driverStatus the driver status
     */
    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    /**
     * Gets current order.
     *
     * @return the current order
     */
    public Order getCurrentOrder() {
        return currentOrder;
    }

    /**
     * Sets current order.
     *
     * @param currentOrder the current order
     */
    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }
}
