package com.ifood.controller;

import com.ifood.model.Customer;
import com.ifood.service.CustomerService;
import java.util.List;

public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    public void add(String name, String phone, String email) {
        service.addCustomer(name, phone, email);
    }

    public void update(int id, String name, String phone, String email) {
        service.updateCustomer(id, name, phone, email);
    }

    public void delete(int id) {
        service.removeCustomer(id);
    }

    public void listAll() {
        List<Customer> customers = service.getAllCustomers();
        if (customers.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        System.out.println("\n=== Lista de Clientes ===");
        for (Customer c : customers) {
            System.out.println("ID: " + c.getId() + " | Nome: " + c.getName() + " | Email: " + c.getEmail());
        }
    }
}