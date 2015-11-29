package com.practice.collection.testcases;

import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * In this test case we populate an arrayList with 100_000_000 random number, without any proper initialization.
 */
public class ArrayListInsertionWithoutInitializationTestCase extends AbstractTestCase {

    private static final UUID ID = UUID.fromString("8a2d46a4-c05d-4a11-b9fe-117f95c4656d");
    private Random random = new Random();
    private List<Integer> testList;

    @Override
    protected void init() {
        testList = new ArrayList<>();
    }

    @Override
    protected long run() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < 100_000_000; i++) {
            testList.add(random.nextInt(100_000_000));
        }
        stopwatch.stop();
        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public UUID getId() {
        return ID;
    }

    @Override
    public String getName() {
        return "ArrayList 100_000_000 element insertion without any pre initialization.";
    }
}
