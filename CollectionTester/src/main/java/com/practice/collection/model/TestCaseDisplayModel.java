package com.practice.collection.model;

public class TestCaseDisplayModel {

    private String id;
    private String name;
    private String implementation;

    public TestCaseDisplayModel(String id, String name, String implementation) {
        this.id = id;
        this.name = name;
        this.implementation = implementation;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setImplementation(String implementation) {
        this.implementation = implementation;
    }

    public String getImplementation() {
        return implementation;
    }
}
