package com.concurrent.service;

import com.concurrent.modell.StatusAndLog;
import com.concurrent.modell.StatusAndLog.Status;
import com.concurrent.testCases.TestCase;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.concurrent.modell.StatusAndLog.Status.IN_PROGRESS;
import static com.concurrent.modell.StatusAndLog.Status.NOT_RUNNING;

@Component
public class TestExecutorServiceImpl implements TestExecutorService, InitializingBean, ApplicationContextAware {

    private List<TestCase> testCases;
    private TestCase runningTestCase;
    private Thread testCaseThread;
    private Status status = NOT_RUNNING;
    private LogService logService;
    private ApplicationContext applicationContext;

    @Autowired
    public TestExecutorServiceImpl(LogService logService) {
        this.logService = logService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, TestCase> availableTestCases = applicationContext.getBeansOfType(TestCase.class);
        testCases = new ArrayList<>();
        for(Map.Entry<String, TestCase> testCase : availableTestCases.entrySet()) {
            testCases.add((TestCase) applicationContext.getBean(testCase.getKey()));
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void executeTest(String testCaseName) throws UnsupportedOperationException {
        if (status.equals(IN_PROGRESS)) {
            throw new UnsupportedOperationException();
        }
        for (TestCase testCase : testCases) {
            if (testCaseName.equals(testCase.getName())) {
                runningTestCase = testCase;
                synchronized (status) {
                    status = IN_PROGRESS;
                }
                runningTestCase.init();
                testCaseThread = new Thread(() -> {
                    try {
                        runningTestCase.execute();
                    } catch (Exception e) {
                        logService.error("Exception occured during " + testCase.getName() + " running. " + e.getMessage());
                    }
                });
                testCaseThread.start();
                break;
            }
        }
    }

    @Override
    public void killTest() {
        logService.info("Interrupt " + runningTestCase.getName());
        status = NOT_RUNNING;
        testCaseThread.interrupt();
    }

    @Override
    public StatusAndLog getProgress() {
        StatusAndLog statusAndLog = new StatusAndLog();
        synchronized (status) {
            if (runningTestCase.isFinished()) {
                status = NOT_RUNNING;
            }
            statusAndLog.setStatus(status);
        }
        statusAndLog.setLogMessages(logService.getLogs());
        return statusAndLog;
    }

    @Override
    public List<TestCase> getTestCases() {
        return testCases;
    }
}
