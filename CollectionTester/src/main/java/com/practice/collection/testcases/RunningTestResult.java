package com.practice.collection.testcases;

public class RunningTestResult {

    private TestResult testResult;
    private RunningState state;

    public RunningTestResult(TestResult testResult, RunningState state) {
        this.testResult = testResult;
        this.state = state;
    }

    public enum RunningState {
        RUNNING,
        DONE
    }

    public TestResult getTestResult() {
        return testResult;
    }

    public void setTestResult(TestResult testResult) {
        this.testResult = testResult;
    }

    public RunningState getState() {
        return state;
    }

    public void setState(RunningState state) {
        this.state = state;
    }
}
