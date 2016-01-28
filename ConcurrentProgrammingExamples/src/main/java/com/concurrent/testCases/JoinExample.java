package com.concurrent.testCases;

import com.concurrent.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JoinExample extends AbstractTestCase {

    @Autowired
    public JoinExample(LogService logService) {
        super(logService);
    }

    @Override
    public String getName() {
        return "Join example";
    }

    @Override
    public void execute() {
        Thread threadToWait = new Thread(() -> {
            try {
                logService.info("Start running dependency thread");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                logService.error("Error while try to sleep " + e.getMessage());
            }
        });
        logService.info("Before join");
        threadToWait.start();
        try {
            threadToWait.join();
        } catch (InterruptedException e) {
            logService.error("Error while try to join " + e.getMessage());
        }
        logService.info("After join");
        super.execute();
    }
}
