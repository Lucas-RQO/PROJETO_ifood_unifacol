package com.ifood.model;

public class Customer extends Person {
    private String email;

    public Customer() {}

    public Customer(int id, String name, String phone, String email) {
        super(id, name, phone);
        this.email = email;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public void displayInfo() {
        System.out.println("Cliente [ID=" + getId() + ", Nome=" + getName() + 
                           ", Telefone=" + getPhone() + ", Email=" + email + "]");
    }

    // Return a single-line representation used by views
    public String getDetails() {
        return "Cliente [ID=" + getId() + ", Nome=" + getName() + ", Telefone=" + getPhone() + ", Email=" + email + "]";
    }

    @Override
    public String toString() { return getDetails(); }
}

