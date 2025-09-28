package com.ifood.model;

public class DeliveryPerson extends Person {
    private String vehicle;

    public DeliveryPerson(int id, String name, String vehicle) {
        super(id, name);
        this.vehicle = vehicle;
    }

    public String getVehicle() { return vehicle; }
    public void setVehicle(String vehicle) { this.vehicle = vehicle; }

    @Override
    public String getDetails() {
        return "Entregador: " + getName() + " | Veículo: " + vehicle;
    }
}
