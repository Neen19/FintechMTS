package ru.mtsbank.demofintech.animals.service.interfaces;

import ru.mtsbank.demofintech.animals.AbstractAnimal;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public interface AnimalRepository {

    /** Функция которая возвращает массив имён животных,
     * родившихся в високосный год
     * @return массив имён
     */
    Map<String, LocalDate> findLeapYearNames();

    /** Функция возвращающая массив животных старших определённого возраста
     *
     * @param age
     * @return массив животных старше чем age
     */
    Map<AbstractAnimal, Integer> findOlderAnimal(int age);

    /** Находит в массиве экземпляры которые встречаются более 1 раза
     * и выводит их на экран
     */

    Map<String, Integer> findDuplicate();

    default void printDuplicate() {
        System.out.println(findDuplicate());
    }

    public Map<String, List<AbstractAnimal>> getAnimals();
}
