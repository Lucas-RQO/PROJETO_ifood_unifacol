package com.ifood.controller;

import com.ifood.model.DeliveryPerson;
import com.ifood.service.DeliveryPersonService;
import java.util.List;

public class DeliveryPersonController {
    private DeliveryPersonService service = new DeliveryPersonService();

    public void addDeliveryPerson(int id, String name, String vehicle) {
        service.addDeliveryPerson(id, name, vehicle);
    }

    public void removeDeliveryPerson(int id) {
        service.removeDeliveryPerson(id);
    }

    public void updateDeliveryPerson(int id, String newName, String newVehicle) {
        service.updateDeliveryPerson(id, newName, newVehicle);
    }

    public DeliveryPerson findDeliveryPersonById(int id) {
        return service.findDeliveryPersonById(id);
    }

    public List<DeliveryPerson> getAllDeliveryPeople() {
        return service.getAllDeliveryPeople();
    }
}
