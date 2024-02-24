package ru.mtsbank.demofintech.animals.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mtsbank.demofintech.animals.AbstractAnimal;
import ru.mtsbank.demofintech.animals.pets.Dog;
import ru.mtsbank.demofintech.animals.service.interfaces.AnimalRepository;
import ru.mtsbank.demofintech.animals.service.interfaces.CreateAnimalService;
import ru.mtsbank.demofintech.utils.MapUtils;
import ru.mtsbank.demofintech.utils.ValidationUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.*;


@Repository
public class AnimalRepositoryImpl implements AnimalRepository {


    private CreateAnimalService service;
    private Map<String, List<AbstractAnimal>> animals;

    public void setService(CreateAnimalService service) {
        this.service = service;
    }

    @Autowired
    public AnimalRepositoryImpl(CreateAnimalService service) {
        this.service = service;
    }

    @PostConstruct
    public void init() {
        try {
            animals = service.genAnimals();
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<String, LocalDate> findLeapYearNames() {
        Map<String, LocalDate> map = new HashMap<>();
        for (String key : animals.keySet()) {
            if (!ValidationUtils.validateAnimal(animals.get(key)))
                throw new IllegalArgumentException("invalid elem in array");
        }

        for (String key : animals.keySet()) {
            List<AbstractAnimal> animalList = animals.get(key);
            for (AbstractAnimal animal : animalList)
                if (animal.getBirthDate().isLeapYear())
                    map.put(animal.getClass() + " " + animal.getName(), animal.getBirthDate());
        }
        return map;
    }

    @Override
    public Map<AbstractAnimal, Integer> findOlderAnimal(int age) {
        Map<AbstractAnimal, Integer> map = new HashMap<>();
        Iterator<Map.Entry<String, List<AbstractAnimal>>> iterator = animals.entrySet().iterator();

        AbstractAnimal oldestAnimal = iterator.next().getValue().get(0);
        for (String key : animals.keySet()) {
            List<AbstractAnimal> animalList = animals.get(key);
            for (AbstractAnimal animal : animalList) {
                int animalAge = animal.getAge();
                if (animalAge >= age) map.put(animal, animal.getAge());
                if (oldestAnimal.getAge() < animal.getAge()) oldestAnimal = animal;
            }
        }
        if (map.isEmpty()) map.put(oldestAnimal, oldestAnimal.getAge());
        return map;
    }


    @Override
    public Map<String, Integer> findDuplicate() {
        Map<String, Integer> map = new HashMap<>();
        Set<AbstractAnimal> set = new HashSet<>();
        for (String key : animals.keySet()) {
            List<AbstractAnimal> animalList = animals.get(key);
            for (AbstractAnimal animal : animalList) {
                if (set.contains(animal)) {
                    MapUtils.increment(map, animal.getClass().getName());
                }
                set.add(animal);
            }
        }
        return map;
    }
}
