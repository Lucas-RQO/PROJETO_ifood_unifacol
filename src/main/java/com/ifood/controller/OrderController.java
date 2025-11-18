package com.ifood.controller;

import com.ifood.model.MenuItem;
import com.ifood.model.Order;
import com.ifood.service.OrderService;
import java.util.List;

public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    public void addOrder(String cliente, int restaurantId, int menuItemId) {
        service.addOrder(cliente, restaurantId, menuItemId);
    }

    public void processNextOrder() {
        service.processNextOrder();
    }

    public void listPendingOrders() {
        List<Order> orders = service.getPendingOrders();
        if (orders.isEmpty()) {
            System.out.println("Nenhum pedido pendente.");
            return;
        }
        System.out.println("\n--- Pedidos Pendentes (Fila) ---");
        orders.forEach(System.out::println);
    }

    public void listCompletedOrders() {
        List<Order> orders = service.getCompletedOrders();
        if (orders.isEmpty()) {
            System.out.println("Nenhum pedido concluído.");
            return;
        }
        System.out.println("\n--- Pedidos Concluídos (Pilha) ---");
        for (int i = orders.size() - 1; i >= 0; i--) {
            System.out.println(orders.get(i));
        }
    }
}