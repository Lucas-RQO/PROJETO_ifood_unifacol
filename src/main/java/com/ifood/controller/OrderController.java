package com.ifood.controller;

import com.ifood.model.*;
import com.ifood.service.OrderService;
import java.util.List;

public class OrderController {
    private OrderService service = new OrderService();

    public void addOrder(int id, Customer customer, DeliveryPerson deliveryPerson,
                         Restaurant restaurant, List<MenuItem> items) {
        service.addOrder(id, customer, deliveryPerson, restaurant, items);
    }

    public void removeOrder(int id) {
        service.removeOrder(id);
    }

    public void updateOrder(int id, Customer customer, DeliveryPerson deliveryPerson,
                            Restaurant restaurant, List<MenuItem> items) {
        service.updateOrder(id, customer, deliveryPerson, restaurant, items);
    }

    public Order findOrderById(int id) {
        return service.findOrderById(id);
    }

    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }
}
