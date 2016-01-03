package com.practice.collection.testcases;

import java.util.*;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

public abstract class AbstractTestCase implements TestCase {

    public static int NUMBER_OF_ELEMENT = 10_000_000;
    private UUID id = UUID.randomUUID();
    private List<Long> executionTimes = new ArrayList<>();
    private Random random = new Random();
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

    @Override
    public UUID getId() {
        return id;
    }
 
    protected int generateARandomNumber() {
        return random.nextInt(100_000_000);
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
