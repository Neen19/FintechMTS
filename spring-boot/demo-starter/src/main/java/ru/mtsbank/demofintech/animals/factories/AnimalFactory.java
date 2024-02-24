package ru.mtsbank.demofintech.animals.factories;

import ru.mtsbank.demofintech.animals.AbstractAnimal;
import ru.mtsbank.demofintech.utils.MapUtils;
import ru.mtsbank.demofintech.utils.RandomUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AnimalFactory extends AbstractAnimalFactory {


    final private Class<? extends AbstractAnimal> ANIMAL_CLASS;
    final private String[] animalNames;

    public AnimalFactory(Class<? extends AbstractAnimal> animalType, String[] animalNames) {
        ANIMAL_CLASS = animalType;
        this.animalNames = animalNames;
    }

    public Map<String, List<AbstractAnimal>> genAnimals(int size)
            throws InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException
    {
        Map<String, List<AbstractAnimal>> animals = new HashMap<>();
        for (int i = 0; i < size; i++) {
            AbstractAnimal animal = RandomUtils.<AbstractAnimal>genRandomClass(ANIMAL_CLASS, animalNames);
            MapUtils.putInMap(animals, animal);
        }
        return animals;
    }


}
