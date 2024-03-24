package ru.mtsbank.demofintech.app.scheduler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mtsbank.demofintech.app.scheduler.thread.ServiceThread;
import ru.mtsbank.demofintech.exception.IllegalSizeException;
import ru.mtsbank.demofintech.service.interfaces.AnimalRepository;
import ru.mtsbank.demofintech.utils.RandomUtils;

import javax.annotation.PostConstruct;
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

    @PostConstruct
    void postConstruct() {
        Thread duplicateThread = new ServiceThread(
                "duplicateThread",
                () -> {
                    while (true) {
                        log.info("\nFIND DUPLICATE\n" + repository.findDuplicate().toString());
                        try {
                            Thread.sleep(10 * 1000L);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );

        Thread findAverageAgeThread = new ServiceThread(
                "findAverageAgeThread",
                () -> {
                    while (true) {
                        log.info("\nFIND AVERAGE AGE\n");
                        repository.findAverageAge(repository.getAnimals().values().stream()
                                .flatMap(List::stream).collect(Collectors.toList()));
                        try {
                            Thread.sleep(20 * 1000L);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
    }

    void doWork() throws IllegalSizeException {
        int num = RandomUtils.genRandomInt(4);
        switch (num) {
            case 0:
                log.info("\nFIND LEAP YEAR NAMES\n" + repository.findLeapYearNames());
                break;
            case 1:
                log.info("\nFIND OLDER ANIMAL\n" + repository.findOlderAnimal(10));
                break;
            case 2:
                log.info("\nFIND OLD AND EXPENSIVE\n" +
                        repository.findOldAndExpensive(repository.getAnimals().values().stream()
                                .flatMap(List::stream).collect(Collectors.toList())));
                break;
            case 3:
                log.info("\nFIND MIN COST ANIMALS\n " +
                        repository.findMinCostAnimals(repository.getAnimals().values().stream()
                                .flatMap(List::stream).collect(Collectors.toList())));
                break;
        }
    }
}
