package di_container.client;


import di_container.annotation.Inject;
import di_container.factory.BeanFactory;
import di_container.model.Person;
import di_container.service.GiftPresenter;

public class NewYearOrganizer {

    @Inject
    private GiftPresenter giftPresenter;

    public void prepareToCelebration() {
        Person person = new Person("Матвей Отчествович");
        giftPresenter.present(person);
    }
}
