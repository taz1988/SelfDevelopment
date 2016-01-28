package com.concurrent.testCases;

import com.concurrent.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RaceConditionTestCase extends AbstractTestCase {

    private int testVariable;

    @Autowired
    public RaceConditionTestCase(LogService logService) {
        super(logService);
    }

    @Override
    public String getName() {
        return "Race condition test race, cause memory consistency error";
    }

    @Override
    public void init() {
        super.init();
        testVariable = 0;
    }

    @Override
    public void execute() {
        List<Thread> threads = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < 10; i++) {
            final int finalJ = j;
            threads.add(new Thread(() -> {
                testVariable = finalJ;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                testVariable *= 2;
                logService.info("testVariable value after calculation should be " + (2 * finalJ)
                        + ". But the vaule is = " + testVariable);
            }));
            j++;
        }
        try {
            for (int i = 0; i < 100; i++) {
                threads.get(i).start();
            }
        } catch (Exception e) {
            logService.error("Error happaned while running " + getName() + " " + e.getMessage());
        } finally {
            super.execute();
        }
    }
}
