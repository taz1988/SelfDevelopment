package com.practice.collection.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * In this test case we populate an arrayList with 10_000_000 random number, without any proper initialization.
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
    protected void run() {
        for (int i = 0; i < 10_000_000; i++) {
            testList.add(random.nextInt(100_000_000));
        }
    }

    @Override
    public UUID getId() {
        return ID;
    }

    @Override
    public String getName() {
        return "ArrayList 10_000_000 element insertion without any pre initialization";
    }

    public void setName(String name) {

    }
}
