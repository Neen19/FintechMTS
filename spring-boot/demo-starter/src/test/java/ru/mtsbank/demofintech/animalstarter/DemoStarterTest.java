package ru.mtsbank.demofintech.animalstarter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mtsbank.demofintech.animals.AbstractAnimal;
import ru.mtsbank.demofintech.service.interfaces.AnimalRepository;
import ru.mtsbank.demofintech.service.interfaces.CreateAnimalService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(classes = Config.class)
public class DemoStarterTest {


    @Autowired
    CreateAnimalService service;

    @Autowired
    AnimalRepository repository;

    @Test
    public void test() {
        System.out.println("start test");
        repository.findMinCostAnimals(repository.getAnimals().values().stream().flatMap(List::stream).collect(Collectors.toList())).stream().forEach(System.out::println);
    }

    @Test
    public void createAnimalServiceGenAnimalsTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        int numOfAnimals = 0;
        Map<String, List<AbstractAnimal>> animalMap = service.genAnimals();
        for (String key : animalMap.keySet()) {
            numOfAnimals += animalMap.get(key).size();
        }
        assertEquals(numOfAnimals, 10);
    }

    @Test
    public void animalRepositoryFindLeapYearNamesTest() {
        repository.findLeapYearNames();
    }

    @Test
    public void animalRepositoryFindOlderAnimalPositiveTest() {
        assertTrue(animalRepositoryFindOlderAnimalPositiveTestPredicate(repository.findOlderAnimal(10)));
    }

    private boolean animalRepositoryFindOlderAnimalPositiveTestPredicate(Map<AbstractAnimal, Integer> animalMap) {
        if (animalMap.size() == 1) return true;
        for (AbstractAnimal key : animalMap.keySet()) {
            if (key.getAge() < 10) return false;
        }
        return true;
    }

    @Test
    public void animalRepositoryFindOlderAnimalNegativeTest() {
        assertTrue(animalRepositoryFindOlderAnimalPositiveTestPredicate(repository.findOlderAnimal(10)));
    }

//    @Test
//    public void animalRepositoryFindDuplicateTest() {
//        assertTrue(animalRepositoryFindDuplicateTestPredicate(repository.findDuplicate(), repository.getAnimals()));
//    }

    private boolean animalRepositoryFindDuplicateTestPredicate (
            Map<String, Integer> duplicateMap,
            Map<String, List<AbstractAnimal>> animalMap) {
        if (duplicateMap.isEmpty()) return true;
        for (String key: animalMap.keySet()) {
            List<AbstractAnimal> list = animalMap.get(key);
            AbstractAnimal duplicate = list.get(0);
            int count = 0;
            for (AbstractAnimal animal : list) {
                if (animal.equals(duplicate)) count++;
            }
            if (count != duplicateMap.get(key)) return false;
        }
        return true;
    }

}