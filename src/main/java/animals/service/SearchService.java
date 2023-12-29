package animals.service;

import animals.AbstractAnimal;

public interface SearchService {

    /** Функция которая возвращает массив имён животных,
     * родившихся в високосный год
     * @param animals массив животных
     * @return массив имён
     */
    String[] findLeapYearNames(AbstractAnimal[] animals);

    /** Функция возвращающая массив животных старших определённого возраста
     *
     * @param animals
     * @param age
     * @return массив животных старше чем age
     */
    AbstractAnimal[] findOlderAnimal(AbstractAnimal[] animals, int age);

    /** Находит в массиве экземпляры которые встречаются более 1 раза
     * и выводит их на экран
     * @param animals
     */

    void findDuplicate(AbstractAnimal[] animals);
}
