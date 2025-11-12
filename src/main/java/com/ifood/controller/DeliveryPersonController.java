package com.ifood.controller;

import java.util.ArrayList;
import java.util.List;

public class DeliveryPersonController {

    private static class DeliveryPerson {
        private static int nextId = 1;
        private final int id;
        private String name;
        private String vehicle;

        public DeliveryPerson(String name, String vehicle) {
            this.id = nextId++;
            this.name = name;
            this.vehicle = vehicle;
        }

        public int getId() { return id; }
        public void setName(String name) { this.name = name; }
        public void setVehicle(String vehicle) { this.vehicle = vehicle; }

        @Override
        public String toString() {
            return "ID: " + id + " | Nome: " + name + " | Veículo: " + vehicle;
        }
    }

    private final List<DeliveryPerson> deliveryPeople = new ArrayList<>();

    public void add(String name, String vehicle) {
        deliveryPeople.add(new DeliveryPerson(name, vehicle));
        System.out.println("✅ Entregador cadastrado com sucesso!");
    }

    public void update(int id, String name, String vehicle) {
        for (DeliveryPerson d : deliveryPeople) {
            if (d.getId() == id) {
                d.setName(name);
                d.setVehicle(vehicle);
                System.out.println("🔄 Entregador atualizado!");
                return;
            }
        }
        System.out.println("⚠️ Entregador não encontrado.");
    }

    public void delete(int id) {
        boolean removed = deliveryPeople.removeIf(d -> d.getId() == id);
        if (removed)
            System.out.println("🗑️ Entregador removido!");
        else
            System.out.println("⚠️ Entregador não encontrado.");
    }

    public void listAll() {
        if (deliveryPeople.isEmpty()) {
            System.out.println("Nenhum entregador cadastrado.");
            return;
        }
        System.out.println("\n=== Lista de Entregadores ===");
        for (DeliveryPerson d : deliveryPeople) {
            System.out.println(d);
        }
    }
}

