package com.ifood.repository;

import com.ifood.model.Order;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class OrderInMemoryRepository implements IOrderRepository {
    
    // Fila para pendentes
    private final Queue<Order> pendingOrders = new LinkedList<>();
    // Pilha para concluídos
    private final Stack<Order> completedOrders = new Stack<>();

    @Override
    public void addPending(Order order) {
        pendingOrders.add(order);
    }

    @Override
    public Order getNextPending() {
        return pendingOrders.poll(); // Retira da fila
    }

    @Override
    public void addCompleted(Order order) {
        completedOrders.push(order); // Adiciona na pilha
    }

    @Override
    public Queue<Order> getPendingOrders() {
        return pendingOrders;
    }

    @Override
    public Stack<Order> getCompletedOrders() {
        return completedOrders;
    }
}