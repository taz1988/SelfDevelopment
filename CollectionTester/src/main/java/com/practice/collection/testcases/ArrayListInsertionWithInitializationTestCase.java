package com.practice.collection.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * In this test case we populate an arrayList with 10_000_000 random number, with proper init.
 */
public class ArrayListInsertionWithInitializationTestCase extends AbstractTestCase {

    private static final UUID ID = UUID.fromString("7b4fe190-4f0a-40ac-af44-db8929544ebc");
    private Random random = new Random();
    private List<Integer> testList;

    @Override
    protected void init() {
        testList = new ArrayList<>(10_000_000);
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
        return "ArrayList 10_000_000 element insertion with pre initialization.";
    }

    public void setName(String name) {

    }
}
