package com.practice.collection.testcases;

import com.practice.collection.service.CollectionImplementationType;

import java.util.Collections;
import java.util.List;

/**
 * Search list elements with binarySearch after sort.
 */
public class BinarySearchTestCase extends AbstractTestCase {

    private List<Integer> listForSearch;
    private CollectionImplementationType implementationType;

    public BinarySearchTestCase(List<Integer> listForSearch, CollectionImplementationType implementationType) {
        this.listForSearch = listForSearch;
        this.implementationType = implementationType;
    }

    @Override
    protected void init() {
        listForSearch.clear();
        for (int i = 0; i < NUMBER_OF_ELEMENT; i++) {
            listForSearch.add(super.generateARandomNumber());
        }
        Collections.sort(listForSearch);
    }

    @Override
    protected void run() {
        for (int i = 0; i < NUMBER_OF_ELEMENT; i++) {
            Collections.binarySearch(listForSearch, super.generateARandomNumber());
        }
    }

    @Override
    public String getName() {
        return implementationType + " " + NUMBER_OF_ELEMENT + " element searching with binarySearch method";
    }
}
