package com.ifood.repository;

import com.ifood.model.DeliveryPerson;
import java.util.ArrayList;
import java.util.List;

public class IDeliveryPersonRepository implements ICrudRepository<DeliveryPerson> {
    private List<DeliveryPerson> deliveryPeople = new ArrayList<>();

    @Override
    public void add(DeliveryPerson entity) {
        deliveryPeople.add(entity);
    }

    @Override
    public void remove(int id) {
        deliveryPeople.removeIf(d -> d.getId() == id);
    }

    @Override
    public void update(int id, DeliveryPerson newEntity) {
        for (int i = 0; i < deliveryPeople.size(); i++) {
            if (deliveryPeople.get(i).getId() == id) {
                deliveryPeople.set(i, newEntity);
                return;
            }
        }
    }

    @Override
    public DeliveryPerson findById(int id) {
        return deliveryPeople.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<DeliveryPerson> findAll() {
        return deliveryPeople;
    }
}
