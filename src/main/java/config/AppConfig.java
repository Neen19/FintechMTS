package config;

import app.animals.AbstractAnimal;
import app.animals.Animal;
import app.animals.factories.AbstractAnimalFactory;
import app.animals.factories.AnimalFactory;
import app.animals.pets.Dog;
import app.animals.service.implementation.CreateAnimalServiceImpl;
import app.animals.service.interfaces.AnimalRepository;
import bpp.AnimalTypeAnnotationPostProcessor;
import org.springframework.context.annotation.*;


@ComponentScan("app")
@Configuration
public class AppConfig {

    @Bean
    public AnimalTypeAnnotationPostProcessor bpp() {
        return new AnimalTypeAnnotationPostProcessor();
    }

}
