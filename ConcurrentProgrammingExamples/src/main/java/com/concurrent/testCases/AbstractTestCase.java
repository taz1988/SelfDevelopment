package com.concurrent.testCases;

import com.concurrent.service.LogService;

public abstract class AbstractTestCase implements TestCase {

    protected boolean finished = true;
    protected LogService logService;

    public AbstractTestCase(LogService logService) {
        this.logService = logService;
    }

    @Override
    public void init() {
        logService.info("Start " + getName() + " test case.");
        finished = false;
    }

    @Override
    public void execute() {
        finished = true;
    }

    @Override
    public boolean isFinished() {
        if (finished) {
            logService.info("Finished " + getName() + " test case.");
        }
        return finished;
    }
}
