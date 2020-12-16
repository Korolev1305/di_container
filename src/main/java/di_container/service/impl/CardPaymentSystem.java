package di_container.service.impl;

import di_container.model.Gift;
import di_container.service.PaymentSystem;

public class CardPaymentSystem implements PaymentSystem {
    public void pay(Gift gift) {
        System.out.println(String.format("Pay %d for gift %s by a CARD",gift.getPrice(),gift.getName()));
    }
}
