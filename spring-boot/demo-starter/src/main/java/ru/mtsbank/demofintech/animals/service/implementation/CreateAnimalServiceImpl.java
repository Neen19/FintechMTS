package ru.mtsbank.demofintech.animals.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import ru.mtsbank.demofintech.animals.AbstractAnimal;
import ru.mtsbank.demofintech.animals.factories.AbstractAnimalFactory;
import ru.mtsbank.demofintech.animals.factories.AnimalFactory;
import ru.mtsbank.demofintech.animals.pets.Cat;
import ru.mtsbank.demofintech.animals.pets.Dog;
import ru.mtsbank.demofintech.animals.predators.Shark;
import ru.mtsbank.demofintech.animals.service.interfaces.CreateAnimalService;
import ru.mtsbank.demofintech.annotation.AnimalType;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
@Scope("prototype")

public class CreateAnimalServiceImpl implements CreateAnimalService {

    private AnimalFactory factory;

    @Value("${animal.cat.names}")
    private String[] catNames;

    @Value("${animal.dog.names}")
    private String[] dogNames;

    @Value("${animal.shark.names}")
    private String[] sharkNames;

    @Value("${animal.wolf.names}")
    private String[] wolfNames;

    @AnimalType()
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
        String[] names;
        if (animalType.equals(Cat.class)) names = catNames;
        else if (animalType.equals(Dog.class)) names = dogNames;
        else if (animalType.equals(Shark.class)) names = sharkNames;
        else names = wolfNames;
        factory = new AnimalFactory(animalType, names);
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
