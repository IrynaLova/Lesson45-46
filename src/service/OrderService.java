package service;

import model.order.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final List<Order> order = new ArrayList<>();

    public void addOrder(Order order) {
        // TODO
    }

    public List<Order> getOrders() {
        return null; //TODO
    }

    public int getSize() {
        return order.size();
    }
    public Order getOrderByName(String name) {
        return null;
    }
}
