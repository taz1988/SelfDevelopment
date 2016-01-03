package com.practice.collection.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * In this test case we populate an arrayList with 10_000_000 random number, with proper init.
 */
public class ArrayListInsertionWithInitializationTestCase extends AbstractTestCase {

    private List<Integer> testList;

    @Override
    protected void init() {
        testList = new ArrayList<>(NUMBER_OF_ELEMENT);
    }

    @Override
    protected void run() {
        for (int i = 0; i < NUMBER_OF_ELEMENT; i++) {
            testList.add(super.generateARandomNumber());
        }
    }

    @Override
    public String getName() {
        return "ArrayList " + NUMBER_OF_ELEMENT + " element insertion with pre initialization";
    }

    public void setName(String name) {

    }
}
