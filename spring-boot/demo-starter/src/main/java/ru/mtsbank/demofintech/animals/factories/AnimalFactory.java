package ru.mtsbank.demofintech.animals.factories;

import ru.mtsbank.demofintech.animals.AbstractAnimal;
import ru.mtsbank.demofintech.utils.RandomUtils;

import java.lang.reflect.InvocationTargetException;



public class AnimalFactory extends AbstractAnimalFactory {


    final private Class<? extends AbstractAnimal> ANIMAL_CLASS;
    final private String[] animalNames;

    public AnimalFactory(Class<? extends AbstractAnimal> animalType, String[] animalNames) {
        ANIMAL_CLASS = animalType;
        this.animalNames = animalNames;
    }

    public AbstractAnimal[] genArray(int size)
            throws InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException
    {
        AbstractAnimal[] array = new AbstractAnimal[size];
        for (int i = 0; i < size; i++) {
            array[i] = RandomUtils.<AbstractAnimal>genRandomClass(ANIMAL_CLASS, animalNames);
        }
        return array;
    }
}
