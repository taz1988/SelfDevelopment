package com.practice.collection.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * In this test case we populate an arrayList with 10_000_000 random number, without any proper initialization.
 */
public class ArrayListInsertionWithoutInitializationTestCase extends AbstractTestCase {

    private static final UUID ID = UUID.randomUUID();
    private List<Integer> testList;

    @Override
    protected void init() {
        testList = new ArrayList<>();
    }

    @Override
    protected void run() {
        for (int i = 0; i < NUMBER_OF_ELEMENT; i++) {
            testList.add(super.generateARandomNumber());
        }
    }

    @Override
    public UUID getId() {
        return ID;
    }

    @Override
    public String getName() {
        return "ArrayList " + NUMBER_OF_ELEMENT + " element insertion without any pre initialization";
    }

    public void setName(String name) {

    }
}
