package com.ifood.repository;

import com.ifood.model.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements CrudRepository<Customer> {
    private List<Customer> customers = new ArrayList<>();

    @Override
    public void add(Customer entity) {
        customers.add(entity);
    }

    @Override
    public void remove(int id) {
        customers.removeIf(c -> c.getId() == id);
    }

    @Override
    public void update(int id, Customer newEntity) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                customers.set(i, newEntity);
                return;
            }
        }
    }

    @Override
    public Customer findById(int id) {
        return customers.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }
}
