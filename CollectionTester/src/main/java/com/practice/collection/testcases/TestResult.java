package com.practice.collection.testcases;

public class TestResult {

    private String name;
    private long min;
    private long max;
    private int numberOfRuns;
    private double average;
    private double deviation;

    public TestResult(String name, long min, long max, int numberOfRuns, double average, double deviation) {
        this.name = name;
        this.min = min;
        this.max = max;
        this.numberOfRuns = numberOfRuns;
        this.average = average;
        this.deviation = deviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMin() {
        return min;
    }

    public void setMin(long min) {
        this.min = min;
    }

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public int getNumberOfRuns() {
        return numberOfRuns;
    }

    public void setNumberOfRuns(int numberOfRuns) {
        this.numberOfRuns = numberOfRuns;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getDeviation() {
        return deviation;
    }

    public void setDeviation(double deviation) {
        this.deviation = deviation;
    }
}
