package di_container.service.impl;

import di_container.model.Gift;
import di_container.model.Person;
import di_container.service.DeliverySystem;

public class PostDeliverySystem implements DeliverySystem {
    public void deliver(Gift gift, Person person) {
        System.out.println(String.format("Deliver a %s to a %s", gift.getName(),person.getFio()));
    }
}
