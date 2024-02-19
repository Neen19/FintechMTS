package ru.mtsbank.demofintech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.mtsbank.demofintech.animals.service.implementation.CreateAnimalServiceImpl;
import ru.mtsbank.demofintech.animals.service.interfaces.CreateAnimalService;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

@SpringBootApplication
@EnableScheduling
public class DemoFintechApplication {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ApplicationContext context = SpringApplication.run(DemoFintechApplication.class, args);
        CreateAnimalServiceImpl service = context.getBean(CreateAnimalServiceImpl.class);
    }

}
