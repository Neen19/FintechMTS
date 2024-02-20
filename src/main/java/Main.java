import app.animals.AbstractAnimal;
import app.animals.service.interfaces.AnimalRepository;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AnimalRepository rep = context.getBean(AnimalRepository.class);
        System.out.println("FIND OLDER ANIMAL:\n");

        for (AbstractAnimal animal : rep.findOlderAnimal(2)) {
            if (animal == null) break;
            System.out.println(animal);
        }

        System.out.println("FIND LEAP YEAR NAMES:\n");

        for (String name : rep.findLeapYearNames()) {
            if (name == null) break;
            System.out.println(name);
        }

        System.out.println("FIND DUPLICATE:\n");

        rep.printDuplicate();

    }
}

