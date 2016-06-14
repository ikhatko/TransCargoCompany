package model.Entities;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * The type Wagon.
 */
@Entity
public class Wagon {
    @Id
    @GeneratedValue
    private int wagonId;

    @Column(nullable = false, unique = true)
    private String licensePlate;

    @Column(nullable = false)
    private int driversChange;

    @Column(nullable = false)
    private float maxWeight;

    @Column(nullable = false)
    private float maxVolume;

    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    private City currentCity;

    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    private WagonStatus wagonStatus;

    /**
     * Instantiates a new Wagon.
     */
    public Wagon() {
    }

    /**
     * Instantiates a new Wagon.
     *
     * @param licensePlate  the license plate
     * @param maxWeight     the max weight
     * @param maxVolume     the max volume
     * @param driversChange the drivers change
     */
    public Wagon(String licensePlate,float maxWeight, float maxVolume, int driversChange) {
        this.licensePlate = licensePlate;
        this.driversChange = driversChange;
        this.maxWeight = maxWeight;
        this.maxVolume = maxVolume;
    }

    /**
     * Instantiates a new Wagon.
     *
     * @param licensePlate  the license plate
     * @param driversChange the drivers change
     * @param maxWeight     the max weight
     * @param maxVolume     the max volume
     * @param currentCity   the current city
     * @param wagonStatus   the wagon status
     */
    public Wagon(String licensePlate, int driversChange, float maxWeight, float maxVolume, City currentCity, WagonStatus wagonStatus) {
        this.licensePlate = licensePlate;
        this.driversChange = driversChange;
        this.maxWeight = maxWeight;
        this.maxVolume = maxVolume;
        this.currentCity = currentCity;
        this.wagonStatus = wagonStatus;
    }

    /**
     * Gets wagon id.
     *
     * @return the wagon id
     */
    public int getWagonId() {
        return wagonId;
    }

    /**
     * Sets wagon id.
     *
     * @param wagonId the wagon id
     */
    public void setWagonId(int wagonId) {
        this.wagonId = wagonId;
    }

    /**
     * Gets license plate.
     *
     * @return the license plate
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Sets license plate.
     *
     * @param licensePlate the license plate
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * Gets drivers change.
     *
     * @return the drivers change
     */
    public int getDriversChange() {
        return driversChange;
    }

    /**
     * Sets drivers change.
     *
     * @param driversChange the drivers change
     */
    public void setDriversChange(int driversChange) {
        this.driversChange = driversChange;
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
     * @param volume the volume
     */
    public void setMaxVolume(float volume) {
        this.maxVolume = volume;
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
     * Gets wagon status.
     *
     * @return the wagon status
     */
    public WagonStatus getWagonStatus() {
        return wagonStatus;
    }

    /**
     * Sets wagon status.
     *
     * @param wagonStatus the wagon status
     */
    public void setWagonStatus(WagonStatus wagonStatus) {
        this.wagonStatus = wagonStatus;
    }

    @Override
    public String toString() {
        return "" + wagonId;
    }
}
