package com.ifood.repository;

import com.ifood.model.Customer;
import java.util.List;
import java.util.ArrayList;

public class CustomerRepository implements ICustomerRepository {
    private final List<Customer> customers = new ArrayList<>();

    @Override
    public void add(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void update(Customer customer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == customer.getId()) {
                customers.set(i, customer);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        customers.removeIf(c -> c.getId() == id);
    }

    @Override
    public Customer findById(int id) {
        return customers.stream()
                        .filter(c -> c.getId() == id)
                        .findFirst()
                        .orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers);
    }
}
