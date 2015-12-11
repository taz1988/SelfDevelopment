package com.practice.collection.testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

public abstract  class AbstractTestCase implements TestCase {

    private List<Long> executionTimes = new ArrayList<>();
    protected abstract void init();
    protected abstract void run();

    @Override
    public TestResult run(int numberOfRuns) {
        executionTimes.clear();
        for(int i = 0; i < numberOfRuns; i++) {
            this.init();
            Stopwatch stopwatch = Stopwatch.createStarted();
            this.run();
            stopwatch.stop();
            executionTimes.add(stopwatch.elapsed(TimeUnit.MILLISECONDS));
        }
        return new TestResult(generateName(numberOfRuns), Collections.min(executionTimes),
                Collections.max(executionTimes), numberOfRuns, average(), deviation());
    }

    private double deviation() {
        double average = average();
        double deviation = 0.0;
        for(Long time : executionTimes) {
            deviation += Math.pow(time - average, 2);
        }
        return Math.sqrt(deviation / executionTimes.size());
    }

    private double average() {
        double average = 0.0;
        for(Long time : executionTimes) {
            average += time;
        }
        return average / executionTimes.size();
    }

    private String generateName(int numberOfRuns) {
        return this.getName() + "_" + numberOfRuns;
    }
}
