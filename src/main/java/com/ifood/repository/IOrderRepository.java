package com.ifood.repository;

import com.ifood.model.Order;
import java.util.ArrayList;
import java.util.List;


public class IOrderRepository implements ICrudRepository<Order> {
    private final List<Order> orders = new ArrayList<>();

    @Override
    public void add(Order entity) {
        orders.add(entity);
    }

    @Override
    public void remove(int id) {
        orders.removeIf(o -> o.getId() == id);
    }

    @Override
    public void update(int id, Order newEntity) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == id) {
                orders.set(i, newEntity);
                return;
            }
        }
    }

    @Override
    public Order findById(int id) {
        return orders.stream().filter(o -> o.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }
}
