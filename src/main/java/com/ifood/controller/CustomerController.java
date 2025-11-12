package com.ifood.controller;

import com.ifood.model.Customer;
import com.ifood.repository.CustomerRepositoryJDBC;
import com.ifood.repository.ICustomerRepository;

import java.util.List;

public class CustomerController {

    private final ICustomerRepository repository = new CustomerRepositoryJDBC();

    public void add(String name, String phone, String email) {
        repository.add(new Customer(name, phone, email));
    }

    public void update(int id, String name, String phone, String email) {
        repository.update(new Customer(id, name, phone, email));
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public void find(int id) {
        Customer customer = repository.findById(id);
        if (customer != null)
            System.out.println(customer);
        else
            System.out.println("⚠️ Cliente não encontrado!");
    }

    public void listAll() {
        List<Customer> customers = repository.findAll();
        if (customers.isEmpty())
            System.out.println("Nenhum cliente cadastrado.");
        else {
            System.out.println("\n=== Lista de Clientes ===");
            customers.forEach(System.out::println);
        }
    }
}
