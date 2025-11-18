package com.ifood.model;

import java.util.List;

public class Order {
    private int id;
    private String customerName;
    private List<MenuItem> items;
    private static int nextId = 1;
    private Restaurant restaurant;
    private DeliveryPerson deliveryPerson;
    private OrderStatus status;

    public Order(int id, String customerName, List<MenuItem> items) {
        this.id = (id == 0) ? nextId++ : id;
        this.customerName = customerName;
        this.items = items;
        this.status = OrderStatus.PENDING; // Todo novo pedido começa como pendente
        this.restaurant = null; // Pode ser definido depois
        this.deliveryPerson = null; // Será atribuído pelo Serviço de Pedidos
    }

    // --- Getters e Setters Antigos ---
    public int getId() { 
        return id; 
    }

    public String getCustomerName() {
        return customerName; 
    }

    public List<MenuItem> getItems() { 
        return items; 
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public DeliveryPerson getDeliveryPerson() {
        return deliveryPerson;
    }

    public void setDeliveryPerson(DeliveryPerson deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    
    
    @Override
    public String toString() {
        // Pega o nome do primeiro item apenas para exibição
        String itemNames = (items.isEmpty() || items.get(0) == null) ? "Nenhum" : items.get(0).getName();
        // Pega o nome do restaurante, se existir
        String restaurantName = (restaurant != null) ? restaurant.getName() : "N/D";
        // Pega o nome do entregador, se existir
        String deliveryPersonName = (deliveryPerson != null) ? deliveryPerson.getName() : "Aguardando";

        return "ID: " + id + " | Status: " + status +
               " | Cliente: " + customerName + 
               " | Restaurante: " + restaurantName +
               " | Entregador: " + deliveryPersonName +
               " | Item: " + itemNames + "...";
    }
}