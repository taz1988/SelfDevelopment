package com.practice.collection.testcases;

import com.practice.collection.service.CollectionImplementationType;

import java.util.AbstractMap;
/**
 * Test map insertion speed in that test case
 */
public class MapInsertionTestCase extends AbstractTestCase {

    private AbstractMap<Integer, Integer> mapToTest;
    private CollectionImplementationType implementationType;

    public MapInsertionTestCase(AbstractMap<Integer, Integer> mapToTest, CollectionImplementationType implementationType) {
        this.mapToTest = mapToTest;
        this.implementationType = implementationType;
    }

    @Override
    protected void init() {
        mapToTest.clear();
    }

    @Override
    protected void run() {
        for (int i = 0; i < NUMBER_OF_ELEMENT; i++) {
            Integer number = super.generateARandomNumber();
            mapToTest.put(number, number);
        }
    }

    @Override
    public String getName() {
        return implementationType + " " + NUMBER_OF_ELEMENT + " element insertion";
    }
}
