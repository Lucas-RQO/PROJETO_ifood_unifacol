package com.ifood.controller;

import com.ifood.model.Restaurant;
import com.ifood.service.RestaurantService;
import java.util.List;

public class RestaurantController {
    private final RestaurantService service;

    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    public void add(String name) {
        service.addRestaurant(name);
    }

    public void update(int id, String name) {
        service.updateRestaurant(id, name);
    }

    public void delete(int id) {
        service.removeRestaurant(id);
    }

    public void listAll() {
        List<Restaurant> restaurants = service.getAllRestaurants();
        if (restaurants.isEmpty()) {
            System.out.println("Nenhum restaurante cadastrado.");
            return;
        }
        System.out.println("\n=== Lista de Restaurantes ===");
        for (Restaurant r : restaurants) {
            System.out.println("ID: " + r.getId() + " | Nome: " + r.getName());
        }
    }
}