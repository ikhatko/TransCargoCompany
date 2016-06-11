package model.Entities;

import javax.persistence.*;

@Entity
public class CargoStatus {

    @Id
    @GeneratedValue
    private int cargoStatusId;

    @Column(nullable = false)
    private String cargoStatusName;

    public CargoStatus() {
    }

    public int getCargoStatusId() {
        return cargoStatusId;
    }

    public void setCargoStatusId(int cargoStatusId) {
        this.cargoStatusId = cargoStatusId;
    }

    public String getStatusName() {
        return cargoStatusName;
    }

    public void setStatusName(String statusName) {
        this.cargoStatusName = statusName;
    }
}
