package model.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The type Wagon status.
 */
@Entity
public class WagonStatus {
    @Id
    @GeneratedValue
    private int wagonStatusId;

    @Column(nullable = false)
    private String statusName;

    /**
     * Instantiates a new Wagon status.
     */
    public WagonStatus() {
    }

    /**
     * Gets wagon status id.
     *
     * @return the wagon status id
     */
    public int getWagonStatusId() {
        return wagonStatusId;
    }

    /**
     * Sets wagon status id.
     *
     * @param wagonStatusId the wagon status id
     */
    public void setWagonStatusId(int wagonStatusId) {
        this.wagonStatusId = wagonStatusId;
    }

    /**
     * Gets status name.
     *
     * @return the status name
     */
    public String getStatusName() {
        return statusName;
    }

    /**
     * Sets status name.
     *
     * @param statusName the status name
     */
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "" + statusName;
    }
}
