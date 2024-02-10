package ru.mtsbank.demofintech.annotation;

import ru.mtsbank.demofintech.animals.AbstractAnimal;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME )
public @interface AnimalType {
    Class<? extends AbstractAnimal> type();
}
