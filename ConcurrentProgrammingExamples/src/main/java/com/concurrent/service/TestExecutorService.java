package com.concurrent.service;

import com.concurrent.modell.StatusAndLog;
import com.concurrent.testCases.TestCase;

import java.util.List;
import java.util.UUID;

public interface TestExecutorService {

    /**
     * Start to execute a test. If a test run and you try to
     * start an another, then throw a UnsupportedOperationException.
     * @param testCaseName - identify a test case
     */
    void executeTest(String testCaseName) throws UnsupportedOperationException;

    /**
     * Kill the actual running test case.
     */
    void killTest();

    /**
     * Give status information and log info about the tests.
     * @return contains status and log info
     */
    StatusAndLog getProgress();

    /**
     * return the available test cases.
     * @return
     */
    List<TestCase> getTestCases();
}
