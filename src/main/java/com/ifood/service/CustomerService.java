package com.ifood.service;

import com.ifood.model.Customer;
import com.ifood.repository.ICustomerRepository;
import java.util.List;

public class CustomerService {
    private final ICustomerRepository repository;

    public CustomerService(ICustomerRepository repository) {
        this.repository = repository;
    }

    public void addCustomer(String name, String phone, String email) {
        Customer customer = new Customer(name, phone, email);
        repository.add(customer);
    }

    public void removeCustomer(int id) {
        repository.delete(id);
    }

    public void updateCustomer(int id, String newName, String newPhone, String newEmail) {
        Customer customer = new Customer(id, newName, newPhone, newEmail);
        repository.update(customer);
    }

    public Customer findCustomerById(int id) {
        return repository.findById(id);
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }
}