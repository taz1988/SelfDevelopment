package com.practice.collection.testcases;

import java.util.LinkedList;
import java.util.List;

/**
 * In this test case we populate a linkedlist with 10_000_000 random number
 */
public class LinkedListInsertionTestCase extends AbstractTestCase {

    private List<Integer> testList;

    @Override
    protected void init() {
        testList = new LinkedList<>();
    }

    @Override
    protected void run() {
        for (int i = 0; i < NUMBER_OF_ELEMENT; i++) {
            testList.add(super.generateARandomNumber());
        }
    }

    @Override
    public String getName() {
        return "LinkedList " + NUMBER_OF_ELEMENT + " element insertion";
    }
}
