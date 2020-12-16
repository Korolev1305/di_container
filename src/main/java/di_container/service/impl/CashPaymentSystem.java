package di_container.service.impl;

import di_container.model.Gift;
import di_container.service.PaymentSystem;

public class CashPaymentSystem implements PaymentSystem {
    @Override
    public void pay(Gift gift) {
        System.out.println(String.format("Pay %d for gift %s by a CASH",gift.getPrice(),gift.getName()));
    }
}
