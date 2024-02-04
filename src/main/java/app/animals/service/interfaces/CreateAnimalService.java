package app.animals.service.interfaces;

import app.animals.AbstractAnimal;
import app.animals.factories.AbstractAnimalFactory;

import java.lang.reflect.InvocationTargetException;

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

    AbstractAnimal[] genAnimals()
            throws InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException;
}
