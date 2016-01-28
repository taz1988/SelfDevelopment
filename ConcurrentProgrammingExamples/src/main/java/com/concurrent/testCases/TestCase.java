package com.concurrent.testCases;

import java.util.UUID;

public interface TestCase {

    /**
     * Return a name which identify the test case
     * @return
     */
    String getName();

    /**
     * Initialize the test case.
     */
    void init();

    /**
     * Execute test case.
     */
    void execute();

    /**
     * True if we finished the execution.
     * @return
     */
    boolean isFinished();
}
