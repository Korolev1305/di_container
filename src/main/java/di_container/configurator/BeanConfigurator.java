package di_container.configurator;

public interface BeanConfigurator {

    <T> Class<? extends T> getImplementationClass(Class<T> clazz);
}
