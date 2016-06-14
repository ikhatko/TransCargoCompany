package model.Entities;

import javax.persistence.*;

/**
 * The type Cargo status.
 */
@Entity
public class CargoStatus {

    @Id
    @GeneratedValue
    private int cargoStatusId;

    @Column(nullable = false)
    private String cargoStatusName;

    /**
     * Instantiates a new Cargo status.
     */
    public CargoStatus() {
    }

    @Override
    public String toString() {
        return "" + cargoStatusName;
    }

    /**
     * Gets cargo status id.
     *
     * @return the cargo status id
     */
    public int getCargoStatusId() {
        return cargoStatusId;
    }

    /**
     * Sets cargo status id.
     *
     * @param cargoStatusId the cargo status id
     */
    public void setCargoStatusId(int cargoStatusId) {
        this.cargoStatusId = cargoStatusId;
    }

    /**
     * Gets status name.
     *
     * @return the status name
     */
    public String getStatusName() {
        return cargoStatusName;
    }

    /**
     * Sets status name.
     *
     * @param statusName the status name
     */
    public void setStatusName(String statusName) {
        this.cargoStatusName = statusName;
    }
}
