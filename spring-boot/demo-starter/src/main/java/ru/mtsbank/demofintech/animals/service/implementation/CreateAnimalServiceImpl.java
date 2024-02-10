package ru.mtsbank.demofintech.animals.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.mtsbank.demofintech.animals.AbstractAnimal;
import ru.mtsbank.demofintech.animals.factories.AbstractAnimalFactory;
import ru.mtsbank.demofintech.animals.factories.AnimalFactory;
import ru.mtsbank.demofintech.animals.pets.Cat;
import ru.mtsbank.demofintech.animals.service.interfaces.CreateAnimalService;
import ru.mtsbank.demofintech.annotation.AnimalType;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
@Scope("prototype")
public class CreateAnimalServiceImpl implements CreateAnimalService {
    @Autowired
    AbstractAnimalFactory factory;
    @AnimalType(type = Cat.class)
    private Class<? extends AbstractAnimal> animalType;



    public AbstractAnimal[] genAnimals(int N) throws
            InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException {
        return factory.genArray(N);
    }

    @PostConstruct
    private void init() {
        factory = new AnimalFactory(List.of(animalType));
    }

    @Override
    public AbstractAnimal[] genAnimals()
            throws InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException {
        return factory.genArray(10);
    }
}
