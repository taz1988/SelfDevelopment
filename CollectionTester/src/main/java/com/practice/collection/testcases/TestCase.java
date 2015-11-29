package com.practice.collection.testcases;

import java.util.UUID;

public interface TestCase {
    UUID getId();
    String getName();
    TestResult run(int numberOfRuns);
}
