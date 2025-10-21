package com.ifood.service;

import com.ifood.model.MenuItem;
import com.ifood.repository.IMenuItemRepository;
import java.util.List;

public class MenuItemService {
    private IMenuItemRepository repository = new IMenuItemRepository();

    public void addMenuItem(int id, String name, double price) {
        MenuItem item = new MenuItem(id, name, price);
        repository.add(item);
    }

    public void removeMenuItem(int id) {
        repository.remove(id);
    }

    public void updateMenuItem(int id, String newName, double newPrice) {
        MenuItem item = new MenuItem(id, newName, newPrice);
        repository.update(id, item);
    }

    public MenuItem findMenuItemById(int id) {
        return repository.findById(id);
    }

    public List<MenuItem> getAllMenuItems() {
        return repository.findAll();
    }
}
