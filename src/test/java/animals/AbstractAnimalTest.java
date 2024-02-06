package animals;

import animals.pets.Cat;
import animals.pets.Dog;
import animals.service.SearchService;
import animals.service.SearchServiceImpl;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractAnimalTest {

    final static Dog TEST_SHARIK = new Dog(
            "Dog",
            "Sharik",
            10.12,
            "soft",
            LocalDate.of(2012, 6, 15)
    );
    static Dog TEST_SHARIK_COPY = new Dog(
            "Dog",
            "Sharik",
            10.12,
            "soft",
            LocalDate.of(2012, 6, 15)
    );
    static Dog TEST_JACK = new Dog(
            "Dog",
            "Jack",
            10.12,
            "soft",
            LocalDate.of(2006, 6, 15)
    );
    static Dog TEST_BOBIK = new Dog(
            "Dog",
            "Bobik",
            10.12,
            "soft",
            LocalDate.of(2005, 6, 15)
    );
    static Cat TEST_SHARIK_CAT = new Cat(
            "Dog",
            "Sharik",
            10.12,
            "soft",
            LocalDate.of(2012, 6, 15)
    );

    static AbstractAnimal[] animals = new AbstractAnimal[]{
            TEST_SHARIK,
            TEST_SHARIK_COPY,
            TEST_JACK,
            TEST_BOBIK,
            TEST_SHARIK_CAT
    };
    static SearchService service = new SearchServiceImpl();


    @Nested
    @DisplayName("equals test for class AbstractAnimal and it hierarchy")
    class EqualsTest {
        @Test
        @DisplayName("equals method test")
        void testEquals() {
            assertEquals(TEST_SHARIK, TEST_SHARIK);
            assertNotEquals(TEST_SHARIK, TEST_BOBIK);
            assertNotEquals(TEST_SHARIK, TEST_SHARIK_CAT);
            assertEquals(TEST_SHARIK, TEST_SHARIK_COPY);
            assertNotEquals(null, TEST_SHARIK);
        }
    }

    // по тз должно быть тут
    @Nested
    class SearchServiceTest {
        @Test
        @DisplayName("findLeapYearNames")
        void testFindLeapYearNames() {
            String[] names = service.findLeapYearNames(animals);
            for (int i = 0; i < 3; i++) {
                assertEquals(names[i], "Sharik");
            }
        }

        @Test
        @DisplayName("findOlderAnimal")
        void testFindOlderAnimal() {
            AbstractAnimal[] result = service.findOlderAnimal(animals, 17);
            assertEquals(result[0], TEST_JACK);
            assertEquals(result[1], TEST_BOBIK);
        }

        @Test
        @DisplayName("findDuplicate")
        void testFindDuplicate() {
            AbstractAnimal[] result = service.findDuplicate(animals);
            assertEquals(result[0], TEST_SHARIK);
        }
    }
}