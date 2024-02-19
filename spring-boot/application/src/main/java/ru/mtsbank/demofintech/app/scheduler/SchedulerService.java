package ru.mtsbank.demofintech.app.scheduler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mtsbank.demofintech.animals.service.interfaces.AnimalRepository;
import ru.mtsbank.demofintech.utils.RandomUtils;

import java.util.Arrays;


@Service
public class SchedulerService {

    final
    AnimalRepository repository;

    private static final Logger log =  LoggerFactory.getLogger(SchedulerService.class);

    @Autowired
    public SchedulerService(AnimalRepository repository) {
        this.repository = repository;
    }

    void doWork() {
        int num = RandomUtils.genRandomInt(3);
        switch (num) {
            case 0:
                log.info("\nFIND LEAP YEAR NAMES\n" + Arrays.toString(repository.findLeapYearNames()));
            case 1:
                log.info("\nFIND DUPLICATE\n" + repository.findDuplicate().toString());
            case 2:
                log.info("\nFIND OLDER ANIMAL\n" + Arrays.toString(repository.findOlderAnimal(5)));
        }
    }
}
