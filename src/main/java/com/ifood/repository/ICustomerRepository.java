package com.ifood.repository;

import com.ifood.model.Customer;
import java.util.List;

public interface ICustomerRepository {
    void add(Customer customer);
    void update(Customer customer);
    void delete(int id);
    Customer findById(int id);
    List<Customer> findAll();
}
