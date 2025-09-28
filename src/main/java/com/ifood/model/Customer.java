package com.ifood.model;

public class Customer extends Person {
    private String address;

    public Customer(int id, String name, String address) {
        super(id, name);
        this.address = address;
    }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @Override
    public String getDetails() {
        return "Cliente: " + getName() + " | Endereço: " + address;
    }
}
