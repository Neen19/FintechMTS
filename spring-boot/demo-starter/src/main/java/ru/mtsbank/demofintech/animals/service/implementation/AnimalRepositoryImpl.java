package ru.mtsbank.demofintech.animals.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mtsbank.demofintech.animals.AbstractAnimal;
import ru.mtsbank.demofintech.animals.service.interfaces.AnimalRepository;
import ru.mtsbank.demofintech.animals.service.interfaces.CreateAnimalService;
import ru.mtsbank.demofintech.utils.ValidationUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Repository
public class AnimalRepositoryImpl implements AnimalRepository {


    private  CreateAnimalService service;
    private AbstractAnimal[] animals;

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
    public String[] findLeapYearNames() {
        if (!ValidationUtils.validateAnimal(animals))
            throw new IllegalArgumentException("invalid elem in array");
        String[] names = new String[animals.length];
        int ind = 0;
        for (AbstractAnimal animal : animals) {
            if (animal.getBirthDate().isLeapYear()) names[ind++] = animal.getName();
        }
        return names;
    }

    @Override
    public AbstractAnimal[] findOlderAnimal(int age) {
        AbstractAnimal[] answer = new AbstractAnimal[animals.length];
        int ind = 0;
        for (AbstractAnimal animal : animals) {
            int animalAge = animal.getAge();
            if (animalAge >= age) answer[ind++] = animal;
        }
        return answer;
    }


    @Override
    public Set<AbstractAnimal> findDuplicate() {
        Set<AbstractAnimal> res = new HashSet<>();
        Set<AbstractAnimal> set = new HashSet<>();
        for (AbstractAnimal animal : animals) {
            if (set.contains(animal)) {
                res.add(animal);
            }
            set.add(animal);
        }
        return res;
    }

}
