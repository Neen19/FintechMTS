package ru.mtsbank.demofintech.animalstarter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mtsbank.demofintech.animals.AbstractAnimal;
import ru.mtsbank.demofintech.animals.service.interfaces.AnimalRepository;
import ru.mtsbank.demofintech.animals.service.interfaces.CreateAnimalService;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(classes = Config.class)
public class DemoStarterTest {


    @Autowired
    CreateAnimalService service;

    @Autowired
    AnimalRepository repository;

    @Test
    public void createAnimalServiceGenAnimalsTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        assertEquals(service.genAnimals().length, 10);
    }

    @Test
    public void animalRepositoryFindLeapYearNamesTest() {
        repository.findLeapYearNames();
    }

    @Test
    public void animalRepositoryFindOlderAnimalPositiveTest() {
        AbstractAnimal[] animals = repository.findOlderAnimal(10);
        int i = 0;
        AbstractAnimal animal = animals[0];
        while (animal != null) {
            assertTrue(animal.getAge() >= 10);
            animal = animals[++i];
        }
    }

    @Test
    public void animalRepositoryFindOlderAnimalNegativeTest() {
        AbstractAnimal[] animals = repository.findOlderAnimal(100);
        int i = 0;
        AbstractAnimal animal = animals[0];
        while (animal != null) {
            assertTrue(animal.getAge() > 10);
            animal = animals[++i];
        }
        assertEquals(i, 0);
    }

    @Test
    public void animalRepositoryFindDuplicateTest() {
        repository.findDuplicate();
    }
    

}