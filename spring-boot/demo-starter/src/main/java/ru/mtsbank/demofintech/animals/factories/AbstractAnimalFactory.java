package ru.mtsbank.demofintech.animals.factories;

import ru.mtsbank.demofintech.animals.AbstractAnimal;

import java.lang.reflect.InvocationTargetException;

public abstract class AbstractAnimalFactory {
    abstract public AbstractAnimal[] genArray(int size) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
