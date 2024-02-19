package app.animals.factories;

import app.animals.AbstractAnimal;
import app.animals.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

//@Component
//@Scope("prototype")
public class AnimalFactory extends AbstractAnimalFactory {


    final private List<Class<? extends AbstractAnimal>> ANIMAL_CLASSES;

    public AnimalFactory(List<Class<? extends AbstractAnimal>> classes) {
        ANIMAL_CLASSES = classes;
    }

    public AbstractAnimal[] genArray(int size)
            throws InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException
    {
        AbstractAnimal[] array = new AbstractAnimal[size];
        for (int i = 0; i < size; i++) {
            array[i] = RandomUtils.<AbstractAnimal>genRandomClass(ANIMAL_CLASSES);
        }
        return array;
    }
}
