package com.ifood.service;

import com.ifood.model.Restaurant;
import com.ifood.repository.IRestaurantRepository;
import java.util.List;

public class RestaurantService {
    private final IRestaurantRepository repository;

    public RestaurantService(IRestaurantRepository repository) {
        this.repository = repository;
    }

    public void addRestaurant(String name) {
        // Usa o construtor SEM id
        repository.add(new Restaurant(name));
    }

    public void updateRestaurant(int id, String newName) {
        // Usa o construtor COM id
        repository.update(new Restaurant(id, newName));
    }

    public void removeRestaurant(int id) {
        repository.delete(id);
    }

    public List<Restaurant> getAllRestaurants() {
        return repository.findAll();
    }
    
    public Restaurant findRestaurantById(int id) {
        return repository.findById(id);
    }
}