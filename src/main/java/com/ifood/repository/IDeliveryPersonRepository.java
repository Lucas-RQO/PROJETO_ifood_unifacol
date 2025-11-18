package com.ifood.repository;

import com.ifood.model.DeliveryPerson;
import java.util.List;


public interface IDeliveryPersonRepository {
    
    void add(DeliveryPerson deliveryPerson);


    void update(DeliveryPerson deliveryPerson);

    
    void delete(int id);

    
    DeliveryPerson findById(int id);

    
    List<DeliveryPerson> findAll();
}