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
            System.out.println(animal.getName());
            System.out.println(LocalDate.now().getYear() - animal.getBirthDate().getYear());
            if ((LocalDate.now().getYear() - animal.getBirthDate().getYear()) > age){
                answer[ind++] = animal;
            }
        }
        return answer;
    }

    @Override
    public void findDuplicate(AbstractAnimal[] animals) {
        Set<AbstractAnimal> set = new HashSet<>();
        for (AbstractAnimal animal : animals) {
            if (set.contains(animal)) System.out.println(animal);
            else set.add(animal);
        }
    }

}
