package model.Entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

/**
 * The type Cargo.
 */
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

    @OneToMany(mappedBy = "waypointCargo", cascade = javax.persistence.CascadeType.PERSIST, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private Set<Waypoint> waypoints;

    /**
     * Instantiates a new Cargo.
     */
    public Cargo() {
    }

    @Override
    public String toString() {
        return "" + cargoId;
    }

    public Set<Waypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(Set<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }

    /**
     * Instantiates a new Cargo.
     *
     * @param name   the name
     * @param weight the weight
     * @param volume the volume
     */
    public Cargo(String name, float weight, float volume) {
        this.name = name;
        this.weight = weight;
        this.volume = volume;
        cargoStatus = new CargoStatus();
        cargoStatus.setCargoStatusId(1);
    }

    /**
     * Instantiates a new Cargo.
     *
     * @param name        the name
     * @param weight      the weight
     * @param volume      the volume
     * @param cargoStatus the cargo status
     */
    public Cargo(String name, float weight, float volume, CargoStatus cargoStatus) {
        this.name = name;
        this.weight = weight;
        this.volume = volume;
        this.cargoStatus = cargoStatus;
    }

    /**
     * Gets cargo id.
     *
     * @return the cargo id
     */
    public int getCargoId() {
        return cargoId;
    }

    /**
     * Sets cargo id.
     *
     * @param cargoId the cargo id
     */
    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * Gets volume.
     *
     * @return the volume
     */
    public float getVolume() {
        return volume;
    }

    /**
     * Sets volume.
     *
     * @param volume the volume
     */
    public void setVolume(float volume) {
        this.volume = volume;
    }

    /**
     * Gets cargo status.
     *
     * @return the cargo status
     */
    public CargoStatus getCargoStatus() {
        return cargoStatus;
    }

    /**
     * Sets cargo status.
     *
     * @param cargoStatus the cargo status
     */
    public void setCargoStatus(CargoStatus cargoStatus) {
        this.cargoStatus = cargoStatus;
    }
}
