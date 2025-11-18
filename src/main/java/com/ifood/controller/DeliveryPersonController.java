package com.ifood.controller;

import com.ifood.model.DeliveryPerson; 
import com.ifood.service.DeliveryPersonService;
import java.util.List;

public class DeliveryPersonController {


    
    private final DeliveryPersonService service;

    
    public DeliveryPersonController(DeliveryPersonService service) {
        this.service = service;
    }
    
    public void add(String name, String vehicle) {
        service.addDeliveryPerson(name, vehicle);
        
    }

    public void update(int id, String name, String vehicle) {
        service.updateDeliveryPerson(id, name, vehicle);
        
    }

    public void delete(int id) {
        service.removeDeliveryPerson(id);

    }

    public void listAll() {

        List<DeliveryPerson> deliveryPeople = service.getAllDeliveryPeople();

        if (deliveryPeople.isEmpty()) {
            System.out.println("Nenhum entregador cadastrado.");
            return;
        }

        System.out.println("\n=== Lista de Entregadores (do Banco de Dados) ===");
        for (DeliveryPerson d : deliveryPeople) {
            
            System.out.println(d.getDetails()); 
        }
    }
}
