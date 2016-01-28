package com.concurrent.controller;

import com.concurrent.modell.StatusAndLog;
import com.concurrent.service.TestExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {

    private TestExecutorService testExecutorService;

    @Autowired
    public AjaxController(TestExecutorService testExecutorService) {
        this.testExecutorService = testExecutorService;
    }

    @RequestMapping("/start")
    public StatusAndLog start(String testCaseName) {
        testExecutorService.executeTest(testCaseName);
        return testExecutorService.getProgress();
    }

    @RequestMapping("/kill")
    public StatusAndLog kill() {
        testExecutorService.killTest();
        return testExecutorService.getProgress();
    }

    @RequestMapping("/progress")
    public StatusAndLog start() {
        return testExecutorService.getProgress();
    }
}
