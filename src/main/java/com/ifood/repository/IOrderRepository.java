package com.ifood.repository;

import com.ifood.model.Order;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public interface IOrderRepository {
    void addPending(Order order);
    Order getNextPending();
    void addCompleted(Order order);
    Queue<Order> getPendingOrders();
    Stack<Order> getCompletedOrders();
}