package com.ifood.service;

import com.ifood.model.Customer;
import com.ifood.repository.ICustomerRepository;
import java.util.List;

public class CustomerService {
    private ICustomerRepository repository = new ICustomerRepository();

    public void addCustomer(int id, String name, String address) {
        Customer customer = new Customer(id, name, address);
        repository.add(customer);
    }

    public void removeCustomer(int id) {
        repository.remove(id);
    }

    public void updateCustomer(int id, String newName, String newAddress) {
        Customer customer = new Customer(id, newName, newAddress);
        repository.update(id, customer);
    }

    public Customer findCustomerById(int id) {
        return repository.findById(id);
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }
}
