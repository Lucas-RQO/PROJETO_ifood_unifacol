package com.ifood.controller;

import com.ifood.model.MenuItem;
import com.ifood.service.MenuItemService;
import java.util.List;

public class MenuItemController {
    private final MenuItemService service;

    public MenuItemController(MenuItemService service) {
        this.service = service;
    }

    public void add(String name, double price) {
        service.addMenuItem(name, price);
    }

    public void update(int id, String name, double price) {
        service.updateMenuItem(id, name, price);
    }

    public void delete(int id) {
        service.removeMenuItem(id);
    }

    public void listAll() {
        List<MenuItem> items = service.getAllMenuItems();
        if (items.isEmpty()) {
            System.out.println("Nenhum item de menu cadastrado.");
            return;
        }
        System.out.println("\n=== Lista de Itens de Menu ===");
        for (MenuItem item : items) {
            // Usando printf para formatar o preço
            System.out.printf("ID: %d | Nome: %s | Preço: R$ %.2f\n",
                    item.getId(), item.getName(), item.getPrice());
        }
    }
}