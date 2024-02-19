package ru.mtsbank.demofintech.animalstarter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.mtsbank.demofintech.animals.service.interfaces.CreateAnimalService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = {Configuration.class, Config.class})
public class AnimalStarterSpringBootTest {

    @Value("${animal.wolf.names}")
    String[] names;

    @Autowired
    String str;

    @Test
    public void testAdd() {
        System.out.println(str);
    }
}
