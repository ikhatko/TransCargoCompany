package model.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cargo {
    @Id
    @GeneratedValue
    private int cargoId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private float weight;

    @Column(nullable = false)
    private float volume;

    @Column(nullable = false)
    private CargoStatus cargoStatus;

    public enum CargoStatus {
        READY,SHIPPED,DELIVERED
    }

    public Cargo() {
    }

    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public CargoStatus getCargoStatus() {
        return cargoStatus;
    }

    public void setCargoStatus(CargoStatus cargoStatus) {
        this.cargoStatus = cargoStatus;
    }
}
