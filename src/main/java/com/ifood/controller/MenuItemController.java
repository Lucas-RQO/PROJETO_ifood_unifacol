package com.ifood.controller;

import com.ifood.model.MenuItem;
import com.ifood.service.MenuItemService;
import java.util.List;

public class MenuItemController {
    private MenuItemService service = new MenuItemService();

    public void addMenuItem(int id, String name, double price) {
        service.addMenuItem(id, name, price);
    }

    public void removeMenuItem(int id) {
        service.removeMenuItem(id);
    }

    public void updateMenuItem(int id, String newName, double newPrice) {
        service.updateMenuItem(id, newName, newPrice);
    }

    public MenuItem findMenuItemById(int id) {
        return service.findMenuItemById(id);
    }

    public List<MenuItem> getAllMenuItems() {
        return service.getAllMenuItems();
    }
}
