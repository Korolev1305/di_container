package di_container.service;

import di_container.annotation.Inject;
import di_container.annotation.PostConstruct;
import di_container.model.Gift;
import di_container.model.Person;

public class GiftPresenter {

    @Inject
    private GiftChooseHelper giftChooseHelper;

    @Inject
    private DeliverySystem deliverySystem;

    @Inject
    private PaymentSystem paymentSystem;

    @PostConstruct
    public void postConstruct() {
        System.out.println("Gift presenter has been initialized");
    }


    public void present(Person person) {
        Gift gift = giftChooseHelper.choose(person);
        System.out.println(String.format("Gift has benn chosen: %s", gift.getName()));
        paymentSystem.pay(gift);
        deliverySystem.deliver(gift, person);
    }
}
