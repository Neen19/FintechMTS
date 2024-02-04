package app.animals.service.implementation;

import annotation.AnimalType;
import app.animals.AbstractAnimal;
import app.animals.factories.AbstractAnimalFactory;
import app.animals.factories.AnimalFactory;
import app.animals.pets.Cat;
import app.animals.pets.Dog;
import app.animals.service.interfaces.CreateAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.annotation.PostConstruct;

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
