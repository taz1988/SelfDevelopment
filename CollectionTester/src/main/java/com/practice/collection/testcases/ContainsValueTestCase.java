package com.practice.collection.testcases;

import com.practice.collection.service.CollectionImplementationType;

import java.util.AbstractMap;

/**
 * @author Zoltan Kornel Torok, taz19880922@gmail.com.
 */
public class ContainsValueTestCase extends AbstractTestCase {

    private AbstractMap<Integer, Integer> mapToTest;
    private CollectionImplementationType implementationType;

    public ContainsValueTestCase(AbstractMap<Integer, Integer> mapToTest, CollectionImplementationType implementationType) {
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
        return implementationType + " " + NUMBER_OF_ELEMENT + " contains value call";
    }
}
