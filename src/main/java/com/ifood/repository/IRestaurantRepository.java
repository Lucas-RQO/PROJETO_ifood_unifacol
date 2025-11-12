package com.ifood.repository;

import com.ifood.model.Restaurant;
import java.util.ArrayList;
import java.util.List;

public class IRestaurantRepository implements ICrudRepository<Restaurant> {
    private final List<Restaurant> restaurants = new ArrayList<>();

    @Override
    public void add(Restaurant entity) {
        restaurants.add(entity);
    }

    @Override
    public void remove(int id) {
        restaurants.removeIf(r -> r.getId() == id);
    }

    @Override
    public void update(int id, Restaurant newEntity) {
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getId() == id) {
                restaurants.set(i, newEntity);
                return;
            }
        }
    }

    @Override
    public Restaurant findById(int id) {
        return restaurants.stream().filter(r -> r.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurants;
    }
}
