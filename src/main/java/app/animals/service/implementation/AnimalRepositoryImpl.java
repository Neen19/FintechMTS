package app.animals.service.implementation;

import app.animals.AbstractAnimal;
import app.animals.service.interfaces.AnimalRepository;
import app.animals.service.interfaces.CreateAnimalService;
import app.animals.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Repository
public class AnimalRepositoryImpl implements AnimalRepository {


    private final CreateAnimalService service;
    private AbstractAnimal[] animals;

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
            LocalDate animalBirth = animal.getBirthDate();
            LocalDate now = LocalDate.now();
            int animalAge = now.getYear() - animalBirth.getYear();
            if (animalBirth.getMonthValue() > now.getMonthValue()) animalAge--;
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
