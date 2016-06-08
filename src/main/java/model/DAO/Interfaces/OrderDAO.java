package model.DAO.Interfaces;

import model.Entities.Order;

public interface OrderDAO {
    Order getOrderById(int orderId);
    void createOrder(Order order);
    void updateOrder(Order order);
    void deleteOrderById(int orderId);
}
