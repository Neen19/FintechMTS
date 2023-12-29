package animals.factories;

import animals.pets.Cat;
import animals.pets.Dog;
import animals.pets.Pet;
import animals.utils.RandomUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class PetAnimalFactory extends AbstractAnimalFactory {
    List<Class<? extends Pet>> PET_CLASSES =
            List.of(Dog.class, Cat.class);

    public Pet[] genArray(int size)
            throws InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException
    {
        Pet[] array = new Pet[size];
        for (int i = 0; i < size; i++) {
            array[i] = RandomUtils.<Pet>genRandomClass(PET_CLASSES);
        }
        return array;
    }
}
