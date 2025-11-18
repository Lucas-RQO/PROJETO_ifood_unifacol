package com.ifood.repository;

import com.ifood.model.Restaurant;
import java.util.List;

public interface IRestaurantRepository {
    void add(Restaurant restaurant);
    void update(Restaurant restaurant);
    void delete(int id);
    Restaurant findById(int id);
    List<Restaurant> findAll();
}