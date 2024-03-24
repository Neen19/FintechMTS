package ru.mtsbank.demofintech.app.scheduler.thread;

import java.util.function.Function;

public class ServiceThread extends Thread {
    Runnable runnable;
    String name;

    public ServiceThread(String name, Runnable runnable) {
        super(runnable);
        this.setName(name);
        this.start();
    }

}
