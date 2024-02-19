package ru.mtsbank.demofintech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import ru.mtsbank.demofintech.bpp.AnimalTypeAnnotationPostProcessor;



@Configuration
@ComponentScan("ru.mtsbank.demofintech")
@PropertySource("classpath:application.properties")
public class AnimalStarterConfig {


    @Bean
    public AnimalTypeAnnotationPostProcessor bpp() {
        return new AnimalTypeAnnotationPostProcessor();
    }

}
