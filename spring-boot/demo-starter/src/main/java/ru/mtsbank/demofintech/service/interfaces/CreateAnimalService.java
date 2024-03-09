package ru.mtsbank.demofintech.service.interfaces;

import ru.mtsbank.demofintech.animals.AbstractAnimal;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public interface CreateAnimalService {

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


    /**
     * Выводит на экран информацию о 10 сгенерированных
     * экземплярах AbstractAnimal, не обрабатывает ошибки
     *
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */

    public Map<String, List<AbstractAnimal>> genAnimals()
            throws InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException;
}
