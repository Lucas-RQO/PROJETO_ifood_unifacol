package com.ifood.service;

import com.ifood.model.MenuItem;
import com.ifood.repository.IMenuItemRepository;
import java.util.List;

public class MenuItemService {
    private final IMenuItemRepository repository;

    public MenuItemService(IMenuItemRepository repository) {
        this.repository = repository;
    }

    public void addMenuItem(String name, double price) {
        repository.add(new MenuItem(name, price));
    }

    public void updateMenuItem(int id, String newName, double newPrice) {
        repository.update(new MenuItem(id, newName, newPrice));
    }

    public void removeMenuItem(int id) {
        repository.delete(id);
    }

    public List<MenuItem> getAllMenuItems() {
        return repository.findAll();
    }
}