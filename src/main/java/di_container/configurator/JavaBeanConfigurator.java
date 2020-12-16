package di_container.configurator;

import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JavaBeanConfigurator implements BeanConfigurator {

    private final Reflections scanner;
    private final Map<Class,Class> interfaceToImplementation;
    public JavaBeanConfigurator(String packageToScan,  Map<Class,Class> interfaceToImplementation) {
        this.interfaceToImplementation = new HashMap<>(interfaceToImplementation);
        this.scanner = new Reflections(packageToScan);
    }

    @Override
    public <T> Class<? extends T> getImplementationClass(Class<T> interfaceClass) {
        return interfaceToImplementation.computeIfAbsent(interfaceClass, clazz -> {
            Set<Class<? extends T>> implementationsClasses = scanner.getSubTypesOf(interfaceClass);

            if(implementationsClasses.size() != 1) {
                throw new RuntimeException("Найдено больше 1 реализации");
            }

            return implementationsClasses.stream().findFirst().get();
        });

    }
}
