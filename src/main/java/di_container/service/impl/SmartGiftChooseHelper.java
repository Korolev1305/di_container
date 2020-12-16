package di_container.service.impl;

import di_container.annotation.Inject;
import di_container.model.Gift;
import di_container.model.Person;
import di_container.service.GiftChooseHelper;
import di_container.service.Recommendator;

public class SmartGiftChooseHelper implements GiftChooseHelper {

    @Inject
    Recommendator recommendator;

    public Gift choose(Person person) {
        recommendator.recommend();
        Gift gift = new Gift();
        gift.setName("Smart watch");
        gift.setPrice(10000);
        return gift;
    }
}
