package com.ifood.controller;

import com.ifood.model.Customer;
import com.ifood.service.CustomerService;
import java.util.List;

public class CustomerController {
    private CustomerService service = new CustomerService();

    public void addCustomer(int id, String name, String address) {
        service.addCustomer(id, name, address);
    }

    public void removeCustomer(int id) {
        service.removeCustomer(id);
    }

    public void updateCustomer(int id, String newName, String newAddress) {
        service.updateCustomer(id, newName, newAddress);
    }

    public Customer findCustomerById(int id) {
        return service.findCustomerById(id);
    }

    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }
}
