package ru.mtsbank.demofintech.animalstarter;


import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import ru.mtsbank.demofintech.animals.service.implementation.AnimalRepositoryImpl;
import ru.mtsbank.demofintech.animals.service.implementation.CreateAnimalServiceImpl;
import ru.mtsbank.demofintech.animals.service.interfaces.AnimalRepository;
import ru.mtsbank.demofintech.animals.service.interfaces.CreateAnimalService;

@TestConfiguration
public class Configuration {

    @Bean
    CreateAnimalService createAnimalService() {
        return new CreateAnimalServiceImpl();
    }

    @Bean
    AnimalRepository animalRepository() {
        return new AnimalRepositoryImpl(createAnimalService());
    }
}
