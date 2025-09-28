package com.ifood.service;

import com.ifood.model.*;
import com.ifood.repository.OrderRepository;
import java.util.List;

public class OrderService {
    private OrderRepository repository = new OrderRepository();

    public void addOrder(int id, Customer customer, DeliveryPerson deliveryPerson,
                         Restaurant restaurant, List<MenuItem> items) {
        Order order = new Order(id, customer, deliveryPerson, restaurant, items);
        repository.add(order);
    }

    public void removeOrder(int id) {
        repository.remove(id);
    }

    public void updateOrder(int id, Customer customer, DeliveryPerson deliveryPerson,
                            Restaurant restaurant, List<MenuItem> items) {
        Order order = new Order(id, customer, deliveryPerson, restaurant, items);
        repository.update(id, order);
    }

    public Order findOrderById(int id) {
        return repository.findById(id);
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }
}
