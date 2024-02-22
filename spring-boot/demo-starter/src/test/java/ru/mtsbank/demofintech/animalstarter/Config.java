package ru.mtsbank.demofintech.animalstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.*;
import ru.mtsbank.demofintech.animals.service.implementation.AnimalRepositoryImpl;
import ru.mtsbank.demofintech.animals.service.implementation.CreateAnimalServiceImpl;
import ru.mtsbank.demofintech.animals.service.interfaces.AnimalRepository;
import ru.mtsbank.demofintech.animals.service.interfaces.CreateAnimalService;
import ru.mtsbank.demofintech.bpp.AnimalTypeAnnotationPostProcessor;


@Configuration
public class Config {

    @Bean
    @Scope("prototype")
    CreateAnimalService createAnimalService() {
        return new CreateAnimalServiceImpl();
    }

    @Bean
    AnimalRepository animalRepository() {
        return new AnimalRepositoryImpl(createAnimalService());
    }

    @Bean
    AnimalTypeAnnotationPostProcessor bpp() {
        return new AnimalTypeAnnotationPostProcessor();
    }


}
