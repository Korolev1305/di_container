package di_container.factory;

import di_container.annotation.Inject;
import di_container.config.Configuration;
import di_container.config.JavaConfiguration;
import di_container.configurator.BeanConfigurator;
import di_container.configurator.JavaBeanConfigurator;
import di_container.context.ApplicationContext;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BeanFactory {

    private final Configuration configuration;
    private final BeanConfigurator beanConfigurator;
    private ApplicationContext applicationContext;

    public BeanFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        this.configuration = new JavaConfiguration();
        this.beanConfigurator = new JavaBeanConfigurator(configuration.getPackageToScan(), configuration.getInterfaceToImplementationMap());
    }

    @SneakyThrows
    public <T> T getBean(Class<T> clazz) {
        Class<? extends T> implementationClass = clazz;
        if (implementationClass.isInterface()) {
            implementationClass = beanConfigurator.getImplementationClass(implementationClass);
        }

        T bean = implementationClass.getDeclaredConstructor().newInstance();

        for (Field field : Arrays.stream(implementationClass.getDeclaredFields()).filter(field -> field.isAnnotationPresent(Inject.class))
                .collect(Collectors.toList())) {
            field.setAccessible(true);
            field.set(bean, applicationContext.getBean(field.getType()));
        }

        return bean;
    }
}
