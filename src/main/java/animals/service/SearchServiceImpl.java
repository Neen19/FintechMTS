package animals.service;

import animals.AbstractAnimal;
import animals.utils.ValidationUtils;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class SearchServiceImpl implements SearchService {
    @Override
    public String[] findLeapYearNames(AbstractAnimal[] animals) {
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
    public AbstractAnimal[] findOlderAnimal(AbstractAnimal[] animals, int age) {
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
    public AbstractAnimal[] findDuplicate(AbstractAnimal[] animals) {
        AbstractAnimal[] res = new AbstractAnimal[animals.length];
        int ind = 0;
        Set<AbstractAnimal> set = new HashSet<>();
        for (AbstractAnimal animal : animals) {
            if (set.contains(animal)) {
                res[ind++] = animal;
            }
            set.add(animal);
        }
        System.out.println(set);
        return res;
    }

}
