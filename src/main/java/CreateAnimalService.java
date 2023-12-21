package main.java;

import main.java.animals.AbstractAnimal;
import main.java.animals.pets.Cat;
import main.java.animals.pets.Dog;
import main.java.animals.predators.Shark;
import main.java.animals.predators.Wolf;
import main.java.animals.utils.RandomUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CreateAnimalService {

    /**
     * Массив реализованных классов наследников AbstrctAnimal
     */
    List<Class<? extends AbstractAnimal>> ANIMAL_CLASSES =
            List.of(Shark.class, Dog.class, Cat.class, Wolf.class);

    /**
     * Функция которая создаёт случайный экземпляр из vararg
     * классов наслкдников AbstrctAnimal, не обрабатывает ошибки
     *
     * @param classes
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */

    default AbstractAnimal genRandomClass(List<Class<? extends AbstractAnimal>> classes) throws
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        int index = RandomUtils.genRandomInt(classes.size());
        return classes.get(index).getDeclaredConstructor().newInstance();
    }

    /**
     * Выводит на экран информацию о 10 сгенерированных
     * экземплярах AbstractAnimal, не обрабатывает ошибки
     *
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */

    default void genAnimals() throws InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException {
        int i = 0;
        while (i++ < 10) {
            AbstractAnimal animal = genRandomClass(ANIMAL_CLASSES);
            System.out.println(animal);
        }
    }
}
