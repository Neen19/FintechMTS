package ru.mtsbank.demofintech.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mtsbank.demofintech.animals.AbstractAnimal;
import ru.mtsbank.demofintech.exception.IllegalAgeException;
import ru.mtsbank.demofintech.exception.IllegalInstanceException;
import ru.mtsbank.demofintech.exception.IllegalSizeException;
import ru.mtsbank.demofintech.service.interfaces.AnimalRepository;
import ru.mtsbank.demofintech.service.interfaces.CreateAnimalService;
import ru.mtsbank.demofintech.utils.ValidationUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;


@Repository
public class AnimalRepositoryImpl implements AnimalRepository {


    private final CreateAnimalService service;
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
                .peek(it -> {
                    if (!ValidationUtils.validateListOfClass(it, AbstractAnimal.class))
                        throw new IllegalInstanceException("List contains not Animal class");
                })
                .flatMap(List::stream)
                .filter(animal -> animal.getBirthDate().isLeapYear())
                .collect(Collectors.toConcurrentMap(
                        animal -> animal.getClass().getName() + " " + animal.getName(),
                        AbstractAnimal::getBirthDate,
                        (r1, r2) -> r1
                ));
    }

    @Override
    public Map<AbstractAnimal, Integer> findOlderAnimal(int age) {

        if (age < 0) throw new IllegalAgeException("Age less than 0");

        Map<AbstractAnimal, Integer> map = animals.values().stream()
                .peek(it -> {
                    if (!ValidationUtils.validateListOfClass(it, AbstractAnimal.class))
                        throw new IllegalInstanceException("List contains not Animal class");
                })
                .flatMap(List::stream)
                .filter(animal -> animal.getAge() >= age)
                .collect(Collectors.toConcurrentMap(
                        animal -> animal,
                        AbstractAnimal::getAge,
                        (r1, r2) -> r1
                ));

        if (map.isEmpty()) {
            return animals.values().stream()
                    .flatMap(List::stream)
                    .max(Comparator.comparingInt(AbstractAnimal::getAge))
                    .stream().collect(Collectors.toConcurrentMap(
                            animal -> animal,
                            AbstractAnimal::getAge,
                            (r1, r2) -> r1
                    ));
        }
        return map;
    }


    @Override
    public Map<String, List<AbstractAnimal>> findDuplicate() {

        Map<AbstractAnimal, List<AbstractAnimal>> duplicatesMap = animals.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingByConcurrent(animal -> animal));

        return duplicatesMap.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .collect(Collectors.toConcurrentMap(
                        entry -> entry.getKey().getClass().getName(),
                        Map.Entry::getValue,
                        (r1, r2) -> r1
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
                .collect(Collectors.toCollection(CopyOnWriteArrayList::new));
    }

    @Override
    public List<String> findMinCostAnimals(List<AbstractAnimal> animals) throws IllegalSizeException {

        if (animals.isEmpty()) throw new IllegalSizeException("Empty list");

        return animals.stream()
                .sorted(Comparator.comparingInt(AbstractAnimal::getAge))
                .limit(3)
                .map(AbstractAnimal::getName)
                .sorted()
                .collect(Collectors.toCollection(CopyOnWriteArrayList::new));
    }
}
