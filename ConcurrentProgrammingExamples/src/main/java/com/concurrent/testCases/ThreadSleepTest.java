package com.concurrent.testCases;

import com.concurrent.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThreadSleepTest extends AbstractTestCase {

    @Autowired
    public ThreadSleepTest(LogService logService) {
        super(logService);
    }

    @Override
    public String getName() {
        return "Sleep a thread, and after a time continue it.";
    }

    @Override
    public void execute() {
        for (int i = 0; i < 10; i++) {
            logService.info(i + ". run. sleep thread to 1000 ms.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logService.error("InterruptedExeption happened during sleep.");
            }
        }
        super.execute();
    }
}
