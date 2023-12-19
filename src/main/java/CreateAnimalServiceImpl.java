package main.java;

import main.java.animals.AbstractAnimal;
import java.lang.reflect.InvocationTargetException;

public class CreateAnimalServiceImpl implements CreateAnimalService {


    public void genAnimals(int N) throws
            InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException {
        for (int i = 0; i < N; i++) {
            AbstractAnimal animal = genRandomClass(ANIMAL_CLASSES);
            System.out.println(animal);
        }
    }

    @Override
    public void genAnimals() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        int n = 0;
        do {
            AbstractAnimal animal = genRandomClass(ANIMAL_CLASSES);
            System.out.println(animal);
        } while (++n < 10);
    }
}
