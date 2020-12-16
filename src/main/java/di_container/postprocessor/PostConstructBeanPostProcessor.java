package di_container.postprocessor;

import di_container.annotation.PostConstruct;
import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PostConstructBeanPostProcessor implements BeanPostProcessor {

    @Override
    @SneakyThrows
    public void process(Object bean) {
        for(Method method : Arrays.stream(bean.getClass().getDeclaredMethods()).filter(method -> method.isAnnotationPresent(PostConstruct.class))
                .collect(Collectors.toList())) {
            method.invoke(bean);
        }
    }
}
