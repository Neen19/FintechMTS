package ru.mtsbank.demofintech.animals.factories;

import ru.mtsbank.demofintech.animals.AbstractAnimal;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public abstract class AbstractAnimalFactory {
    abstract public Map<String, List<AbstractAnimal>> genAnimals(int size) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
