package animals.service;

import animals.AbstractAnimal;
import animals.factories.AbstractAnimalFactory;

import java.lang.reflect.InvocationTargetException;

public class CreateAnimalServiceImpl implements CreateAnimalService {


    public AbstractAnimal[] genAnimals(AbstractAnimalFactory factory, int N) throws
            InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException {
        return factory.genArray(N);
    }

    @Override
    public AbstractAnimal[] genAnimals(AbstractAnimalFactory factory)
            throws InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException {
        return factory.genArray(10);
    }
}
