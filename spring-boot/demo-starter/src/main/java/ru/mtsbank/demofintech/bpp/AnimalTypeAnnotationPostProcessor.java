package ru.mtsbank.demofintech.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.CannotLoadBeanClassException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.util.ReflectionUtils;
import ru.mtsbank.demofintech.animals.AbstractAnimal;
import ru.mtsbank.demofintech.animals.factories.AnimalFactory;
import ru.mtsbank.demofintech.animals.pets.Cat;
import ru.mtsbank.demofintech.animals.pets.Dog;
import ru.mtsbank.demofintech.animals.predators.Shark;
import ru.mtsbank.demofintech.animals.predators.Wolf;
import ru.mtsbank.demofintech.annotation.AnimalType;
import ru.mtsbank.demofintech.utils.RandomUtils;

import java.lang.reflect.Field;
import java.util.Arrays;


public class AnimalTypeAnnotationPostProcessor implements BeanPostProcessor {

    Class<? extends AbstractAnimal>[] animalClasses = new Class[]{Cat.class, Dog.class, Wolf.class, Shark.class};

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            AnimalType annotation = field.getAnnotation(AnimalType.class);
            if (annotation != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, RandomUtils.getRandomFromArray(animalClasses));
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
