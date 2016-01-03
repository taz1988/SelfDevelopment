package com.practice.collection.testcases;

import com.practice.collection.service.CollectionImplementationType;

import java.util.AbstractMap;

/**
 * test containskey method for different map implementations
 */
public class ContainsKeyTestCase extends AbstractTestCase {

    private AbstractMap<Integer, Integer> mapToTest;
    private CollectionImplementationType implementationType;

    public ContainsKeyTestCase(AbstractMap<Integer, Integer> mapToTest, CollectionImplementationType implementationType) {
        this.mapToTest = mapToTest;
        this.implementationType = implementationType;
    }

    @Override
    protected void init() {
        mapToTest.clear();
        for (int i = 0; i < NUMBER_OF_ELEMENT; i++) {
            Integer number = super.generateARandomNumber();
            mapToTest.put(number, number);
        }
    }

    @Override
    protected void run() {
        for (int i = 0; i < NUMBER_OF_ELEMENT; i++) {
            mapToTest.containsKey(super.generateARandomNumber());
        }
    }

    @Override
    public String getName() {
        return implementationType + " " + NUMBER_OF_ELEMENT + " contains key call";
    }
}
