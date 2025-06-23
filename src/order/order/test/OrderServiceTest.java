package order.order.test;

import order.order.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import order.order.service.OrderService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {
    private OrderService orderService;
    private List<Order> expectedOrders;

    @BeforeEach
    void setUp(){
        orderService = new OrderService();
        expectedOrders = new ArrayList<>();
        expectedOrders.addAll(List.of(
                new Order("Pizza",15.0, LocalDateTime.now(). minusDays(14)),
                new Order ("Sushi", 6.0, LocalDateTime.now().minusDays(6)),
                new Order("Salat",10.6, LocalDateTime.now())
        ));
        expectedOrders.forEach(o -> orderService.addOrder(o));
    }

    @Test
    void addOrder() {
        Order order = new Order("Shashlik",100500, LocalDateTime.now().minusDays(5));
        orderService.addOrder(order);
        assertEquals(4, orderService.getSize());
        assertEquals(order, orderService.getAllOrders().getLast());
        orderService.addOrder(null);
        assertEquals(4, orderService.getSize());
    }

    @Test
    void getAllOrders() {
        List<Order> actual = orderService.getAllOrders();
        assertEquals(3, orderService.getSize());
        assertArrayEquals(expectedOrders.toArray(), actual.toArray());
    }

    @Test
    void getSize() {
        assertEquals(3, orderService.getSize());
    }

    @Test
    void getOrderByName() {
        Order order = orderService.getOrderByName("Sushi");
        assertEquals(6.0,order.getPrice());
        assertTrue(expectedOrders.contains(order));
    }

}
