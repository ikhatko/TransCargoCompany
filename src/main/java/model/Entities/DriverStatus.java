package model.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DriverStatus {
    @Id
    @GeneratedValue
    private int driverStatusId;

    @Column(nullable = false)
    private String driverStatus;

    public DriverStatus() {
    }

    public int getDriverStatusId() {
        return driverStatusId;
    }

    public void setDriverStatusId(int driverStatusId) {
        this.driverStatusId = driverStatusId;
    }

    public String getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(String driverStatus) {
        this.driverStatus = driverStatus;
    }
}
