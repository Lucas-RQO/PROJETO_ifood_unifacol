package com.ifood.controller;

import java.util.ArrayList;
import java.util.List;

public class MenuItemController {

    private static class MenuItem {
        private static int nextId = 1;
        private final int id;
        private String name;
        private double price;

        public MenuItem(String name, double price) {
            this.id = nextId++;
            this.name = name;
            this.price = price;
        }

        public int getId() { return id; }
        public void setName(String name) { this.name = name; }
        public void setPrice(double price) { this.price = price; }

        @Override
        public String toString() {
            return String.format("ID: %d | Nome: %s | Preço: R$ %.2f", id, name, price);
        }
    }

    private final List<MenuItem> menuItems = new ArrayList<>();

    public void add(String name, double price) {
        menuItems.add(new MenuItem(name, price));
        System.out.println("✅ Item de menu cadastrado com sucesso!");
    }

    public void update(int id, String name, double price) {
        for (MenuItem m : menuItems) {
            if (m.getId() == id) {
                m.setName(name);
                m.setPrice(price);
                System.out.println("🔄 Item de menu atualizado!");
                return;
            }
        }
        System.out.println("⚠️ Item não encontrado.");
    }

    public void delete(int id) {
        boolean removed = menuItems.removeIf(m -> m.getId() == id);
        if (removed)
            System.out.println("🗑️ Item removido!");
        else
            System.out.println("⚠️ Item não encontrado.");
    }

    public void listAll() {
        if (menuItems.isEmpty()) {
            System.out.println("Nenhum item de menu cadastrado.");
            return;
        }
        System.out.println("\n=== Lista de Itens de Menu ===");
        for (MenuItem m : menuItems) {
            System.out.println(m);
        }
    }
}
