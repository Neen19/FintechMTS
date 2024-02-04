package annotation;

import app.animals.AbstractAnimal;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME )
public @interface AnimalType {
    Class<? extends AbstractAnimal> type();
}
