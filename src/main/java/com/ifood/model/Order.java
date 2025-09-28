package com.ifood.model;

import java.util.List;

public class Order {
    private int id;
    private Customer customer;
    private DeliveryPerson deliveryPerson;
    private Restaurant restaurant;
    private List<MenuItem> items;

    public Order(int id, Customer customer, DeliveryPerson deliveryPerson,
                 Restaurant restaurant, List<MenuItem> items) {
        this.id = id;
        this.customer = customer;
        this.deliveryPerson = deliveryPerson;
        this.restaurant = restaurant;
        this.items = items;
    }

    public int getId() { return id; }
    public Customer getCustomer() { return customer; }
    public DeliveryPerson getDeliveryPerson() { return deliveryPerson; }
    public Restaurant getRestaurant() { return restaurant; }
    public List<MenuItem> getItems() { return items; }

    @Override
    public String toString() {
        return "Pedido #" + id + " | Cliente: " + customer.getName()
                + " | Restaurante: " + restaurant.getName()
                + " | Itens: " + items.size();
    }
}
