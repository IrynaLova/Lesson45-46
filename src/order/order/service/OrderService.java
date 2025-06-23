package order.order.service;

import order.order.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final List<Order> order = new ArrayList<>();


    public void addOrder(Order order) {
        if(order != null) {
            this.order.add(order);

        }
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(this.order);
    }

    public int getSize() {
        return order.size();
    }
    public Order getOrderByName(String name) {
        return order.stream()
                .filter(order -> order.getDish().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
