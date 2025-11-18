package com.ifood.model;

public class DeliveryPerson extends Person {
    private String vehicle;

    public DeliveryPerson(String name, String vehicle) {
        
        super(0, name, "");
        this.vehicle = vehicle;
    }

    public DeliveryPerson(int id, String name, String vehicle) {
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
