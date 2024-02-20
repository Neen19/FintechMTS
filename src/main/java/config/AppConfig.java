package config;

import app.animals.service.implementation.CreateAnimalServiceImpl;
import app.animals.service.interfaces.CreateAnimalService;
import bpp.AnimalTypeAnnotationPostProcessor;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;


@ComponentScan("app")
@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public AnimalTypeAnnotationPostProcessor bpp() {
        return new AnimalTypeAnnotationPostProcessor();
    }

    @Bean
    @Scope("prototype")
    public CreateAnimalService createAnimalService() {
        return new CreateAnimalServiceImpl();
    }
}
