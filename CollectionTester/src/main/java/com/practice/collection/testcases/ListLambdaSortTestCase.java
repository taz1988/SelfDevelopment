package com.practice.collection.testcases;

import java.util.List;
import java.util.Collections;
import java.util.UUID;
import com.practice.collection.service.CollectionImplementationType;

public class ListLambdaSortTestCase extends AbstractTestCase {

    private UUID id = UUID.randomUUID();
    private List<Integer> listToSort;
    private CollectionImplementationType implementationType;
    
    public ListLambdaSortTestCase(List<Integer> listToSort, CollectionImplementationType implementationType) {
        this.listToSort = listToSort;
        this.implementationType = implementationType;
    }

     @Override
    protected void init() {
        listToSort.clear();
        for (int i = 0; i < NUMBER_OF_ELEMENT; i++) {
            listToSort.add(super.generateARandomNumber());
        }
    }

    @Override
    protected void run() {
        listToSort.sort((Integer number1, Integer number2)->number1.compareTo(number2));
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getName() {
        return implementationType + " " + NUMBER_OF_ELEMENT + " element sorting with lambda sort";
    }
}
