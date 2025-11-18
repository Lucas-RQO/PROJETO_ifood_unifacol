package com.ifood.repository;

import com.ifood.model.MenuItem;
import java.util.List;

public interface IMenuItemRepository {
    void add(MenuItem item);
    void update(MenuItem item);
    void delete(int id);
    List<MenuItem> findAll();

    MenuItem findById(int id);
}