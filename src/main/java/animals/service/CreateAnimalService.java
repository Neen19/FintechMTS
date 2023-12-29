package animals.service;

import animals.AbstractAnimal;
import animals.factories.AbstractAnimalFactory;
import animals.utils.RandomUtils;

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

    default AbstractAnimal[] genAnimals(AbstractAnimalFactory factory)
            throws InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException
    {
        return factory.genArray(10);
    }
}
