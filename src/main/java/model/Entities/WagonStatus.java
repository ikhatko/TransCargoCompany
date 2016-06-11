package model.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WagonStatus {
    @Id
    @GeneratedValue
    private int wagonStatusId;

    @Column(nullable = false)
    private String statusName;

    public WagonStatus() {
    }

    public int getWagonStatusId() {
        return wagonStatusId;
    }

    public void setWagonStatusId(int wagonStatusId) {
        this.wagonStatusId = wagonStatusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
