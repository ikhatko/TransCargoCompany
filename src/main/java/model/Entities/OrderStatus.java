package model.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The type Order status.
 */
@Entity
public class OrderStatus {

    @Id
    @GeneratedValue
    private int orderStatusId;

    @Column(nullable = false)
    private String orderStatusName;

    /**
     * Instantiates a new Order status.
     */
    public OrderStatus() {
    }

    @Override
    public String toString() {
        return orderStatusName;
    }

    /**
     * Gets order status id.
     *
     * @return the order status id
     */
    public int getOrderStatusId() {
        return orderStatusId;
    }

    /**
     * Sets order status id.
     *
     * @param orderStatusId the order status id
     */
    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    /**
     * Gets order status name.
     *
     * @return the order status name
     */
    public String getOrderStatusName() {
        return orderStatusName;
    }

    /**
     * Sets order status name.
     *
     * @param orderStatusName the order status name
     */
    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }
}
