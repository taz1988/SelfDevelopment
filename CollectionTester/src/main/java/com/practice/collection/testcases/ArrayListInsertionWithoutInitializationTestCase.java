package com.practice.collection.testcases;

import java.util.ArrayList;
import java.util.List;

/**
 * In this test case we populate an arrayList with 10_000_000 random number, without any proper initialization.
 */
public class ArrayListInsertionWithoutInitializationTestCase extends AbstractTestCase {

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
    public String getName() {
        return "ArrayList " + NUMBER_OF_ELEMENT + " element insertion without any pre initialization";
    }

    public void setName(String name) {

    }
}
