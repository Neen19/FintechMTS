package ru.mtsbank.demofintech.app.scheduler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
        } catch (Throwable th) {
            System.out.println(th);
        }

    }
}

