package ru.mtsbank.demofintech.app.scheduler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mtsbank.demofintech.exception.IllegalAgeException;
import ru.mtsbank.demofintech.exception.IllegalInstanceException;
import ru.mtsbank.demofintech.exception.IllegalSizeException;

@Component
public class Scheduler {

    private final SchedulerService service;

    @Autowired
    public Scheduler(SchedulerService service) {
        this.service = service;
    }

    @Scheduled(fixedDelay = 1000L )
    public void doWork() {
        try {
            service.doWork();
        } catch (IllegalSizeException e) {
            System.out.println("IllegalSizeException " + e.getMessage());
        } catch (IllegalInstanceException e) {
            System.out.println("IllegalInstanceException " + e.getMessage());
        } catch (IllegalAgeException e) {
            System.out.println("IllegalAgeException " + e.getMessage());
        }
    }
}

