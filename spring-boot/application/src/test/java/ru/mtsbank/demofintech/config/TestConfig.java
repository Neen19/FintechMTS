package ru.mtsbank.demofintech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.mtsbank.demofintech.service.implementation.AnimalRepositoryImpl;
import ru.mtsbank.demofintech.service.implementation.CreateAnimalServiceImpl;
import ru.mtsbank.demofintech.service.interfaces.AnimalRepository;
import ru.mtsbank.demofintech.service.interfaces.CreateAnimalService;
import ru.mtsbank.demofintech.bpp.AnimalTypeAnnotationPostProcessor;

@Configuration
public class TestConfig {
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
