package bpp;

import annotation.AnimalType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;


public class AnimalTypeAnnotationPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            AnimalType annotation = field.getAnnotation(AnimalType.class);
            if (annotation != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, annotation.type());
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
