package di_container.configurator;

import org.reflections.Reflections;

public interface BeanConfigurator {

    <T> Class<? extends T> getImplementationClass(Class<T> clazz);
    Reflections getScanner();
}
