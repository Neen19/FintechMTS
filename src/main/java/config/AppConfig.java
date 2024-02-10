package config;

import bpp.AnimalTypeAnnotationPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan("app")
@Configuration
public class AppConfig {

    @Bean
    public AnimalTypeAnnotationPostProcessor bpp() {
        return new AnimalTypeAnnotationPostProcessor();
    }

}
