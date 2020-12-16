package di_container;

import di_container.client.NewYearOrganizer;
import di_container.context.ApplicationContext;
import di_container.factory.BeanFactory;

public class Application {
    public ApplicationContext run() {
        ApplicationContext applicationContext = new ApplicationContext();
        BeanFactory beanFactory = new BeanFactory(applicationContext);
        applicationContext.setBeanFactory(beanFactory);

        return applicationContext;
    }
    public static void main(String[] args) {
        Application application = new Application();
        ApplicationContext context = application.run();

        NewYearOrganizer newYearOrganizer = context.getBean(NewYearOrganizer.class);
        newYearOrganizer.prepareToCelebration();
    }
}
