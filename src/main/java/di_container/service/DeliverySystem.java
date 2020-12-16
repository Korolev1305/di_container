package di_container.service;

import di_container.model.Gift;
import di_container.model.Person;

public interface DeliverySystem {

    void deliver(Gift gift, Person person);
}
