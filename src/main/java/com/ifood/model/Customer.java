package com.ifood.model;

public class Customer extends Person {
    private String email;

    // Construtor para criar (sem id)
    public Customer(String name, String phone, String email) {
        super(name, phone);
        this.email = email;
    }

    // Construtor para carregar (com id)
    public Customer(int id, String name, String phone, String email) {
        super(id, name, phone);
        this.email = email;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public void displayInfo() {
        System.out.println("Cliente: " + getName() + " | Email: " + email);
    }
}