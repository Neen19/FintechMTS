package bpp;

import annotation.AnimalType;
import app.animals.AbstractAnimal;
import app.animals.pets.Cat;
import app.animals.pets.Dog;
import app.animals.predators.Shark;
import app.animals.predators.Wolf;
import app.animals.utils.RandomUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;


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
