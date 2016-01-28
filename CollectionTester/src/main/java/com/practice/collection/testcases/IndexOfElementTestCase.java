package com.practice.collection.testcases;

import com.practice.collection.service.CollectionImplementationType;

import java.util.List;

/**
 * Search list elements with indexOf.
 */
public class IndexOfElementTestCase extends AbstractTestCase {

    private List<Integer> listForSearch;
    private CollectionImplementationType implementationType;

    public IndexOfElementTestCase(List<Integer> listForSearch, CollectionImplementationType implementationType) {
        this.listForSearch = listForSearch;
        this.implementationType = implementationType;
    }

    @Override
    protected void init() {
        listForSearch.clear();
        for (int i = 0; i < NUMBER_OF_ELEMENT; i++) {
            listForSearch.add(super.generateARandomNumber());
        }
    }

    @Override
    protected void run() {
        for (int i = 0; i < NUMBER_OF_ELEMENT; i++) {
            listForSearch.indexOf(super.generateARandomNumber());
        }
    }

    @Override
    public String getName() {
        return implementationType + " " + NUMBER_OF_ELEMENT + " element searching with indexOf method";
    }
}
