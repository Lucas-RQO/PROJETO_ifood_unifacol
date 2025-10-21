package com.ifood.repository;

import com.ifood.model.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class IMenuItemRepository implements ICrudRepository<MenuItem> {
    private List<MenuItem> items = new ArrayList<>();

    @Override
    public void add(MenuItem entity) {
        items.add(entity);
    }

    @Override
    public void remove(int id) {
        items.removeIf(i -> i.getId() == id);
    }

    @Override
    public void update(int id, MenuItem newEntity) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                items.set(i, newEntity);
                return;
            }
        }
    }

    @Override
    public MenuItem findById(int id) {
        return items.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<MenuItem> findAll() {
        return items;
    }
}
