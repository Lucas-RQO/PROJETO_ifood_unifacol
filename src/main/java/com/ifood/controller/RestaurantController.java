package com.ifood.controller;

import java.util.ArrayList;
import java.util.List;

public class RestaurantController {

    private static class Restaurant {
        private static int nextId = 1;
        private final int id;
        private String name;

        public Restaurant(String name) {
            this.id = nextId++;
            this.name = name;
        }

        public int getId() { return id; }
        public void setName(String name) { this.name = name; }

        @Override
        public String toString() {
            return "ID: " + id + " | Nome: " + name;
        }
    }

    private final List<Restaurant> restaurants = new ArrayList<>();

    public void add(String name) {
        restaurants.add(new Restaurant(name));
        System.out.println("✅ Restaurante cadastrado com sucesso!");
    }

    public void update(int id, String name) {
        for (Restaurant r : restaurants) {
            if (r.getId() == id) {
                r.setName(name);
                System.out.println("🔄 Restaurante atualizado!");
                return;
            }
        }
        System.out.println("⚠️ Restaurante não encontrado.");
    }

    public void delete(int id) {
        boolean removed = restaurants.removeIf(r -> r.getId() == id);
        if (removed)
            System.out.println("🗑️ Restaurante removido!");
        else
            System.out.println("⚠️ Restaurante não encontrado.");
    }

    public void listAll() {
        if (restaurants.isEmpty()) {
            System.out.println("Nenhum restaurante cadastrado.");
            return;
        }
        System.out.println("\n=== Lista de Restaurantes ===");
        for (Restaurant r : restaurants) {
            System.out.println(r);
        }
    }
}
