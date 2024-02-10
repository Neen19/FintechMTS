package ru.mtsbank.demofintech.animals.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.mtsbank.demofintech.bpp.AnimalTypeAnnotationPostProcessor;


@ComponentScan("ru.mtsbank.demofintech")
@Configuration
public class AnimalStarterConfig {

    @Bean
    public AnimalTypeAnnotationPostProcessor bpp() {
        return new AnimalTypeAnnotationPostProcessor();
    }

}
