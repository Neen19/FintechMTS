import animals.AbstractAnimal;
import animals.factories.PredatorAnimalFactory;
import animals.service.CreateAnimalServiceImpl;
import animals.service.SearchServiceImpl;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        SearchServiceImpl searchService = new SearchServiceImpl();
        CreateAnimalServiceImpl createService = new CreateAnimalServiceImpl();
        PredatorAnimalFactory predatorAnimalFactory = new PredatorAnimalFactory();

        AbstractAnimal[] animals = createService.genAnimals(predatorAnimalFactory);


        for (AbstractAnimal animal : animals) {
            System.out.println(animal + "\n");
        }

        searchService.findDuplicate(animals);

        System.out.println("FIND OLDER ANIMAL RESULT");
        AbstractAnimal[] findOlderAnimalResult = searchService.findOlderAnimal(animals, 10);
        for (AbstractAnimal animal : findOlderAnimalResult) {
            if (animal == null) break;
            System.out.println(animal + "\n");
        }

        String[] findLeapYearAnimalsResult = searchService.findLeapYearNames(animals);

        System.out.println("FIND LEAP ANIMALS RESULT");
        for (String result : findLeapYearAnimalsResult) {
            if (result == null) break;
            System.out.println(result);
        }

    }
}

