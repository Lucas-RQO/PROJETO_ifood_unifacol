package com.ifood.controller;

import com.ifood.model.MenuItem;
import com.ifood.service.OrderService;
import java.util.List;

public class OrderController {
    private final OrderService service = new OrderService();

    // Adicionar pedido (compatível com o MainView)
    public void addOrder(int id, String customerName, Object deliveryPerson,
                         Object restaurant, List<MenuItem> items) {
        if (items == null || items.isEmpty()) {
            System.out.println("⚠️ Nenhum item informado para o pedido!");
            return;
        }
        String itemName = items.get(0).getName();
        service.addOrder(customerName, itemName);
    }

    // Processar próximo pedido da fila (FIFO)
    public void processNextOrder() {
        service.processNextOrder();
    }

    // Listar fila de pedidos pendentes
    public void listPendingOrders() {
        service.listPendingOrders();
    }

    // Listar pilha de pedidos concluídos
    public void listCompletedOrders() {
        service.listCompletedOrders();
    }
}
