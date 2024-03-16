package ru.mtsbank.demofintech.app.scheduler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mtsbank.demofintech.exception.IllegalSizeException;
import ru.mtsbank.demofintech.service.interfaces.AnimalRepository;
import ru.mtsbank.demofintech.utils.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchedulerService {

    final
    AnimalRepository repository;

    private static final Logger log = LoggerFactory.getLogger(SchedulerService.class);

    @Autowired
    public SchedulerService(AnimalRepository repository) {
        this.repository = repository;
    }

    void doWork() throws IllegalSizeException {
        int num = RandomUtils.genRandomInt(6);
        switch (num) {
            case 0:
                log.info("\nFIND LEAP YEAR NAMES\n" + repository.findLeapYearNames());
                break;
            case 1:
                log.info("\nFIND DUPLICATE\n" + repository.findDuplicate().toString());
                break;
            case 2:
                log.info("\nFIND OLDER ANIMAL\n" + repository.findOlderAnimal(-1));
                break;
            case 3:
                log.info("\nFIND AVERAGE AGE\n");
                repository.findAverageAge(repository.getAnimals().values().stream()
                        .flatMap(List::stream).collect(Collectors.toList()));
                break;
            case 4:
                log.info("\nFIND OLD AND EXPENSIVE\n" +
                        repository.findOldAndExpensive(repository.getAnimals().values().stream()
                                .flatMap(List::stream).collect(Collectors.toList())));
                break;
            case 5:
                log.info("\nFIND MIN COST ANIMALS\n " +
                        repository.findMinCostAnimals(repository.getAnimals().values().stream()
                                .flatMap(List::stream).collect(Collectors.toList())));
                break;
        }
    }
}
