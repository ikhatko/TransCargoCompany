package model.Entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

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

    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    private CargoStatus cargoStatus;

    public Cargo() {
    }

    public Cargo(String name, float weight, float volume) {
        this.name = name;
        this.weight = weight;
        this.volume = volume;
        cargoStatus = new CargoStatus();
        cargoStatus.setCargoStatusId(1);
    }

    public Cargo(String name, float weight, float volume, CargoStatus cargoStatus) {
        this.name = name;
        this.weight = weight;
        this.volume = volume;
        this.cargoStatus = cargoStatus;
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
