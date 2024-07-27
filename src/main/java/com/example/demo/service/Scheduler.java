package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    @Scheduled(cron = "* * * ? * ?")
    public void cronJobSchedulingTask() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy HH:mm:ss.SSS");
        String strDate = dateFormat.format(new Date());
        System.out.println("Cron job Scheduler: Job running at - " + strDate);
    }

    @Scheduled(fixedRate = 2000)
    public void fixedRateSchedulingTask() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy HH:mm:ss.SSS");
        String strDate = dateFormat.format(new Date());
        System.out.println("Fixed rate Scheduler: Job running at - " + strDate);
    }

    @Scheduled(fixedDelay = 3000, initialDelay=5000)
    public void fixedDelaySchedulingTask() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy HH:mm:ss.SSS");
        String strDate = dateFormat.format(new Date());
        System.out.println("Fixed delay Scheduler: Job running at - " + strDate);
    }
}
