package animals.factories;

import animals.predators.Predator;
import animals.predators.Shark;
import animals.predators.Wolf;
import animals.utils.RandomUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class PredatorAnimalFactory extends AbstractAnimalFactory {

    List<Class<? extends Predator>> PREDATOR_CLASSES =
            List.of(Shark.class, Wolf.class);

    public Predator[] genArray(int size)
            throws InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException
    {
        Predator[] array = new Predator[size];
        for (int i = 0; i < size; i++) {
            array[i] = RandomUtils.<Predator>genRandomClass(PREDATOR_CLASSES);
        }
        return array;
    }
}
