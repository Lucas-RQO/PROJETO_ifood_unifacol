package com.ifood.service;

import com.ifood.model.Customer;
import com.ifood.repository.CustomerRepositoryJDBC;
import java.util.List;

public class CustomerService {
    private final CustomerRepositoryJDBC repository = new CustomerRepositoryJDBC();

    // Adicionando cliente
    public void addCustomer(int id, String name, String phone, String email) {
        Customer customer = new Customer(id, name, phone, email);
        repository.add(customer);
    }

    // Remover cliente
    public void removeCustomer(int id) {
        repository.delete(id);
    }

    // Atualizar cliente
    public void updateCustomer(int id, String newName, String newPhone, String newEmail) {
        Customer customer = new Customer(id, newName, newPhone, newEmail);
        repository.update(customer);
    }

    // Buscar cliente
    public Customer findCustomerById(int id) {
        return repository.findById(id);
    }

    // Listar todos
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }
}
