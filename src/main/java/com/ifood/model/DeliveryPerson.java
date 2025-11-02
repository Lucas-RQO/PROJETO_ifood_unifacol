package com.ifood.model;

public class DeliveryPerson extends Person {
    private String vehicle;

    public DeliveryPerson(int id, String name, String vehicle) {
        // Person currently expects (id, name, phone) - provide empty phone if not available
        super(id, name, "");
        this.vehicle = vehicle;
    }

    public String getVehicle() { return vehicle; }
    public void setVehicle(String vehicle) { this.vehicle = vehicle; }

    public String getDetails() {
        return "Entregador: " + getName() + " | Veículo: " + vehicle;
    }

    @Override
    public void displayInfo() {
        System.out.println(getDetails());
    }
}
