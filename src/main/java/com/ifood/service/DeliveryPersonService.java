package com.ifood.service;

import com.ifood.model.DeliveryPerson;
import com.ifood.repository.IDeliveryPersonRepository;
import java.util.List;

public class DeliveryPersonService {
    private IDeliveryPersonRepository repository = new IDeliveryPersonRepository();

    public void addDeliveryPerson(int id, String name, String vehicle) {
        DeliveryPerson deliveryPerson = new DeliveryPerson(id, name, vehicle);
        repository.add(deliveryPerson);
    }

    public void removeDeliveryPerson(int id) {
        repository.remove(id);
    }

    public void updateDeliveryPerson(int id, String newName, String newVehicle) {
        DeliveryPerson deliveryPerson = new DeliveryPerson(id, newName, newVehicle);
        repository.update(id, deliveryPerson);
    }

    public DeliveryPerson findDeliveryPersonById(int id) {
        return repository.findById(id);
    }

    public List<DeliveryPerson> getAllDeliveryPeople() {
        return repository.findAll();
    }
}
