package com.ifood.controller;

import com.ifood.model.Customer;
import com.ifood.service.CustomerService;

import java.util.List;

public class CustomerController {
    private final CustomerService service = new CustomerService();

    public void addCustomer(int id, String name, String phone, String email) {
        service.addCustomer(id, name, phone, email); // ✅ passar o email
    }

    public void removeCustomer(int id) {
        service.removeCustomer(id);
    }

    public void updateCustomer(int id, String newName, String newPhone, String newEmail) {
        service.updateCustomer(id, newName, newPhone, newEmail); // ✅ passar o email
    }

    public Customer findCustomerById(int id) {
        return service.findCustomerById(id);
    }

    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }
}
