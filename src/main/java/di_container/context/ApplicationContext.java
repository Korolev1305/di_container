package di_container.context;

import di_container.factory.BeanFactory;
import di_container.postprocessor.BeanPostProcessor;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {

    @Setter
    private BeanFactory beanFactory;
    private final Map<Class, Object> beanMap = new ConcurrentHashMap<>();

    public ApplicationContext() {
    }

    public <T> T getBean(Class<T> clazz) {
        if (beanMap.containsKey(clazz)) {
            return (T) beanMap.get(clazz);
        }
        T bean = beanFactory.getBean(clazz);
        callPostProcessors(bean);

        beanMap.put(clazz, bean);

        return bean;

    }

    @SneakyThrows
    private void callPostProcessors(Object bean) {
        for(Class processor : beanFactory.getBeanConfigurator().getScanner().getSubTypesOf(BeanPostProcessor.class)) {
            BeanPostProcessor beanPostProcessor = (BeanPostProcessor) processor.getDeclaredConstructor().newInstance();
            beanPostProcessor.process(bean);
        }
    }
}
