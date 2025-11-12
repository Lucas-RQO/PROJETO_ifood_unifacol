package com.ifood.service;

import java.util.*;

// Classe simples representando um pedido
class Order {
    private final int id;
    private final String customerName;
    private final String item;
    private String status;

    public Order(int id, String customerName, String item) {
        this.id = id;
        this.customerName = customerName;
        this.item = item;
        this.status = "Pendente";
    }

    public int getId() { return id; }
    public String getCustomerName() { return customerName; }
    public String getItem() { return item; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void displayInfo() {
        System.out.println("Pedido #" + id + " | Cliente: " + customerName +
                " | Item: " + item + " | Status: " + status);
    }
}

public class OrderService {

    // Fila de pedidos pendentes (FIFO)
    private final Queue<Order> pendingOrders = new LinkedList<>();

    // Pilha de pedidos concluídos (LIFO)
    private final Stack<Order> completedOrders = new Stack<>();

    // Controle de ID automático
    private int nextId = 1;

    // Adicionar novo pedido à fila de pendentes
    public void addOrder(String customerName, String item) {
        Order order = new Order(nextId++, customerName, item);
        pendingOrders.add(order);
        System.out.println("✅ Pedido adicionado à fila de pendentes!");
    }

    // Processar o próximo pedido (FIFO)
    public void processNextOrder() {
        if (pendingOrders.isEmpty()) {
            System.out.println("⚠️ Nenhum pedido pendente para processar!");
            return;
        }

        Order order = pendingOrders.poll(); // remove da fila
        order.setStatus("Concluído");
        completedOrders.push(order); // adiciona na pilha
        System.out.println("✅ Pedido processado e movido para concluídos:");
        order.displayInfo();
    }

    // Exibir fila de pedidos pendentes
    public void listPendingOrders() {
        if (pendingOrders.isEmpty()) {
            System.out.println("Nenhum pedido pendente.");
            return;
        }
        System.out.println("\n=== Pedidos Pendentes ===");
        for (Order o : pendingOrders) o.displayInfo();
    }

    // Exibir pilha de pedidos concluídos
    public void listCompletedOrders() {
        if (completedOrders.isEmpty()) {
            System.out.println("Nenhum pedido concluído.");
            return;
        }
        System.out.println("\n=== Pedidos Concluídos ===");
        for (Order o : completedOrders) o.displayInfo();
    }
}
