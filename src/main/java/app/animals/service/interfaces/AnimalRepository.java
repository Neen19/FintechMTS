package app.animals.service.interfaces;

import app.animals.AbstractAnimal;

import java.util.Set;

public interface AnimalRepository {

    /** Функция которая возвращает массив имён животных,
     * родившихся в високосный год
     * @param animals массив животных
     * @return массив имён
     */
    String[] findLeapYearNames();

    /** Функция возвращающая массив животных старших определённого возраста
     *
     * @param animals
     * @param age
     * @return массив животных старше чем age
     */
    AbstractAnimal[] findOlderAnimal(int age);

    /** Находит в массиве экземпляры которые встречаются более 1 раза
     * и выводит их на экран
     * @param animals
     */

    Set<AbstractAnimal> findDuplicate();

    default void printDuplicate() {
        System.out.println(findDuplicate());
    }
}
