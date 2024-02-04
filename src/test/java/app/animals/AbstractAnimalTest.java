package app.animals;

import app.animals.pets.Cat;
import app.animals.pets.Dog;
import app.animals.service.interfaces.AnimalRepository;
import app.animals.service.implementation.AnimalRepositoryImpl;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractAnimalTest {

    static Dog sharik;
    static Dog sharikCopy;
    static Dog jack;
    static Dog bobik;
    static Cat sharikCat;

    static AbstractAnimal[] animals;
    static AnimalRepository service = new AnimalRepositoryImpl();

    @BeforeAll
    static void initAnimals() {
        sharik = new Dog(
                "Dog",
                "Sharik",
                10.12,
                "soft",
                LocalDate.of(2012, 6, 15)
        );
        jack = new Dog(
                "Dog",
                "Jack",
                10.12,
                "soft",
                LocalDate.of(2006, 6, 15)
        );
        bobik = new Dog(
                "Dog",
                "Bobik",
                10.12,
                "soft",
                LocalDate.of(2004, 6, 15)
        );
        sharikCopy = new Dog(
                "Dog",
                "Sharik",
                10.12,
                "soft",
                LocalDate.of(2012, 6, 15)
        );
        sharikCat = new Cat(
                "Dog",
                "Sharik",
                10.12,
                "soft",
                LocalDate.of(2012, 6, 15)
        );
        animals = new AbstractAnimal[5];
        animals[0] = sharik;
        animals[1] = sharikCopy;
        animals[2] = jack;
        animals[3] = bobik;
        animals[4] = sharikCat;
    }

    @Nested
    @DisplayName("equals test for class AbstractAnimal and it hierarchy")
    class EqualsTest {
        @Test
        @DisplayName("equals method on same object")
        void sameEquals() {
            assertEquals(sharik, sharik);
        }

        @Test
        @DisplayName("equals method on the different object")
        void diffEquals() {
            assertNotEquals(sharik, bobik);
        }

        @Test
        @DisplayName("equals method on the different class object with same fields")
        void diffClassSameFieldsEquals() {
            assertNotEquals(sharik, sharikCat);
        }

        @Test
        @DisplayName("equals method on the different objects with same fields")
        void diffObjSameFieldsEquals() {
            assertEquals(sharik, sharikCopy);
        }

        @Test
        @DisplayName("equals method on null")
        void nullEquals() {
            assertNotEquals(null, sharik);
        }
    }

    // по тз должно быть тут
    @Nested
    class SearchServiceTest {
        @Test
        @DisplayName("findLeapYearNames")
        void findLeapYearNames() {
            String[] names = service.findLeapYearNames(animals);
            for (int i = 0; i < 3; i++) {
                assertEquals(names[i], "Sharik");
            }
        }

        @Test
        @DisplayName("findOlderAnimal")
        void findOlderAnimal() {
            AbstractAnimal[] result = service.findOlderAnimal(animals, 17);
            assertEquals(result[0], jack);
            assertEquals(result[1], bobik);
        }

        @Test
        @DisplayName("findDuplicate")
        void findDuplicate() {
            AbstractAnimal[] result = service.findDuplicate(animals);
            assertEquals(result[0], sharik);
        }
    }
}