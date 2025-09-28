package com.ifood.service;

import com.ifood.model.Restaurant;
import com.ifood.repository.RestaurantRepository;
import java.util.List;

public class RestaurantService {
    private RestaurantRepository repository = new RestaurantRepository();

    public void addRestaurant(int id, String name) {
        Restaurant restaurant = new Restaurant(id, name);
        repository.add(restaurant);
    }

    public void removeRestaurant(int id) {
        repository.remove(id);
    }

    public void updateRestaurant(int id, String newName) {
        Restaurant restaurant = new Restaurant(id, newName);
        repository.update(id, restaurant);
    }

    public Restaurant findRestaurantById(int id) {
        return repository.findById(id);
    }

    public List<Restaurant> getAllRestaurants() {
        return repository.findAll();
    }
}
