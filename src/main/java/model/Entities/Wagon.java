package model.Entities;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;

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

    public Wagon() {
    }

    public Wagon(String licensePlate,float maxWeight, float maxVolume, int driversChange) {
        this.licensePlate = licensePlate;
        this.driversChange = driversChange;
        this.maxWeight = maxWeight;
        this.maxVolume = maxVolume;
    }

    public Wagon(String licensePlate, int driversChange, float maxWeight, float maxVolume, City currentCity, WagonStatus wagonStatus) {
        this.licensePlate = licensePlate;
        this.driversChange = driversChange;
        this.maxWeight = maxWeight;
        this.maxVolume = maxVolume;
        this.currentCity = currentCity;
        this.wagonStatus = wagonStatus;
    }

    public int getWagonId() {
        return wagonId;
    }

    public void setWagonId(int wagonId) {
        this.wagonId = wagonId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getDriversChange() {
        return driversChange;
    }

    public void setDriversChange(int driversChange) {
        this.driversChange = driversChange;
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

    public void setMaxVolume(float volume) {
        this.maxVolume = volume;
    }

    public City getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    public WagonStatus getWagonStatus() {
        return wagonStatus;
    }

    public void setWagonStatus(WagonStatus wagonStatus) {
        this.wagonStatus = wagonStatus;
    }

    @Override
    public String toString() {
        return "" + wagonId;
    }
}
