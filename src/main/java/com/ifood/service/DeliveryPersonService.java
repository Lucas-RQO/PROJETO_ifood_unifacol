package com.ifood.service;

import com.ifood.model.DeliveryPerson;
import com.ifood.repository.IDeliveryPersonRepository;
import java.util.List;

public class DeliveryPersonService {
    
    
    private final IDeliveryPersonRepository repository;

 
    public DeliveryPersonService(IDeliveryPersonRepository repository) {
        this.repository = repository;
    }


    public void addDeliveryPerson(String name, String vehicle) {
     
        DeliveryPerson deliveryPerson = new DeliveryPerson(name, vehicle);
        repository.add(deliveryPerson); 
    }

    public void removeDeliveryPerson(int id) {
      
        repository.delete(id); 
    }

    public void updateDeliveryPerson(int id, String newName, String newVehicle) {
        
        DeliveryPerson deliveryPerson = new DeliveryPerson(id, newName, newVehicle);
        repository.update(deliveryPerson);
    }

    public DeliveryPerson findDeliveryPersonById(int id) {
        return repository.findById(id);
    }

    public List<DeliveryPerson> getAllDeliveryPeople() {
        return repository.findAll();
    }
}