package model.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The type Driver status.
 */
@Entity
public class DriverStatus {
    @Id
    @GeneratedValue
    private int driverStatusId;

    @Column(nullable = false)
    private String driverStatus;

    /**
     * Instantiates a new Driver status.
     */
    public DriverStatus() {
    }

    @Override
    public String toString() {
        return driverStatus;
    }

    /**
     * Gets driver status id.
     *
     * @return the driver status id
     */
    public int getDriverStatusId() {
        return driverStatusId;
    }

    /**
     * Sets driver status id.
     *
     * @param driverStatusId the driver status id
     */
    public void setDriverStatusId(int driverStatusId) {
        this.driverStatusId = driverStatusId;
    }

    /**
     * Gets driver status.
     *
     * @return the driver status
     */
    public String getDriverStatus() {
        return driverStatus;
    }

    /**
     * Sets driver status.
     *
     * @param driverStatus the driver status
     */
    public void setDriverStatus(String driverStatus) {
        this.driverStatus = driverStatus;
    }
}
