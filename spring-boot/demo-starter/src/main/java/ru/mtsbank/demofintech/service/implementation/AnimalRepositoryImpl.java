package ru.mtsbank.demofintech.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mtsbank.demofintech.animals.AbstractAnimal;
import ru.mtsbank.demofintech.animals.pets.Dog;
import ru.mtsbank.demofintech.service.interfaces.AnimalRepository;
import ru.mtsbank.demofintech.service.interfaces.CreateAnimalService;
import ru.mtsbank.demofintech.utils.ValidationUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Repository
public class AnimalRepositoryImpl implements AnimalRepository {


    private CreateAnimalService service;
    private Map<String, List<AbstractAnimal>> animals;


    public Map<String, List<AbstractAnimal>> getAnimals() {
        return animals;
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

        return animals.values().stream()
                .filter(ValidationUtils::validateAnimal)
                .flatMap(List::stream)
                .filter(animal -> animal.getBirthDate().isLeapYear())
                .collect(Collectors.toMap(
                        animal -> animal.getClass().getName() + " " + animal.getName(),
                        AbstractAnimal::getBirthDate
                ));
    }

    @Override
    public Map<AbstractAnimal, Integer> findOlderAnimal(int age) {

        Map<AbstractAnimal, Integer> map = animals.values().stream()
                .filter(ValidationUtils::validateAnimal)
                .flatMap(List::stream)
                .filter(animal -> animal.getAge() >= age)
                .collect(Collectors.toMap(
                        animal -> animal,
                        AbstractAnimal::getAge
                ));
        if (map.isEmpty()) {
            return animals.values().stream()
                    .flatMap(List::stream)
                    .max(Comparator.comparingInt(AbstractAnimal::getAge))
                    .stream().collect(Collectors.toMap(
                            animal -> animal,
                            AbstractAnimal::getAge
                    ));
        }
        return map;
    }


    @Override
    public Map<String, List<AbstractAnimal>> findDuplicate() {
        Map<AbstractAnimal, List<AbstractAnimal>> duplicatesMap = animals.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(animal -> animal));

        return duplicatesMap.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getClass().getName(),
                        Map.Entry::getValue
                ));
    }

    @Override
    public void findAverageAge(List<AbstractAnimal> animals) {
        System.out.println(animals.stream()
                .mapToInt(AbstractAnimal::getAge)
                .average());
    }

    @Override
    public List<AbstractAnimal> findOldAndExpensive(List<AbstractAnimal> animals) {
        OptionalDouble averageCostOpt = animals.stream()
                .mapToDouble(animal -> animal.getCost().doubleValue())
                .average();
        double averageCost = averageCostOpt.getAsDouble();
        return animals.stream()
                .filter(animal -> animal.getAge() > OLD_AGE)
                .filter(animal -> animal.getCost().doubleValue() > averageCost)
                .sorted(Comparator.comparingInt(AbstractAnimal::getAge))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findMinCostAnimals(List<AbstractAnimal> animals) {
        return animals.stream()
                .sorted(Comparator.comparingInt(AbstractAnimal::getAge))
                .limit(3)
                .map(AbstractAnimal::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
