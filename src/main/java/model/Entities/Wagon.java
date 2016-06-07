package model.Entities;

import javax.persistence.*;

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
    private City currentCity;

    @Column(nullable = false)
    private WagonStatus wagonStatus;

    public enum WagonStatus {
        GOOD, BROKEN
    }

    public Wagon() {
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

}
