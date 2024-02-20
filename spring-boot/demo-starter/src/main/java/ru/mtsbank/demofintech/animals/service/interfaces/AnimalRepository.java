package ru.mtsbank.demofintech.animals.service.interfaces;

import ru.mtsbank.demofintech.animals.AbstractAnimal;

import java.util.Set;

public interface AnimalRepository {

    /** Функция которая возвращает массив имён животных,
     * родившихся в високосный год
     * @return массив имён
     */
    String[] findLeapYearNames();

    /** Функция возвращающая массив животных старших определённого возраста
     *
     * @param age
     * @return массив животных старше чем age
     */
    AbstractAnimal[] findOlderAnimal(int age);

    /** Находит в массиве экземпляры которые встречаются более 1 раза
     * и выводит их на экран
     */

    Set<AbstractAnimal> findDuplicate();

    default void printDuplicate() {
        System.out.println(findDuplicate());
    }
}
