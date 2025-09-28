package com.ifood.controller;

import com.ifood.model.Restaurant;
import com.ifood.service.RestaurantService;
import java.util.List;

public class RestaurantController {
    private RestaurantService service = new RestaurantService();

    public void addRestaurant(int id, String name) {
        service.addRestaurant(id, name);
    }

    public void removeRestaurant(int id) {
        service.removeRestaurant(id);
    }

    public void updateRestaurant(int id, String newName) {
        service.updateRestaurant(id, newName);
    }

    public Restaurant findRestaurantById(int id) {
        return service.findRestaurantById(id);
    }

    public List<Restaurant> getAllRestaurants() {
        return service.getAllRestaurants();
    }
}
