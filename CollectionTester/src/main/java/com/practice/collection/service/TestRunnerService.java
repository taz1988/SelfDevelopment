package com.practice.collection.service;

import com.practice.collection.testcases.RunningTestResult;
import com.practice.collection.testcases.TestCase;
import com.practice.collection.testcases.TestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static com.practice.collection.testcases.RunningTestResult.RunningState.DONE;
import static com.practice.collection.testcases.RunningTestResult.RunningState.RUNNING;

@Component
public class TestRunnerService {

    private List<TestResult> completedTestResults = new ArrayList<>();
    private Map<CollectionImplementationType, List<TestCase>> testCases;
    private RunningTestResult.RunningState state;

    public TestRunnerService(Map<CollectionImplementationType, List<TestCase>> testCases) {
        this.testCases = testCases;
    }

    public void start(CollectionImplementationType type, UUID id, int numberOfRuns) {
        Optional<TestCase> selectedTestCase = searchTestCase(type, id);
        if (selectedTestCase.isPresent()) {
            state = RUNNING;
            (new Thread(createRunnable(selectedTestCase, numberOfRuns))).start();
        }
    }

    private Runnable createRunnable(Optional<TestCase> selectedTestCase, int numberOfRuns) {
        return () -> {
            completedTestResults.add(selectedTestCase.get().run(numberOfRuns));
            state = DONE;
        };
    }

    private Optional<TestCase> searchTestCase(CollectionImplementationType type, UUID id) {
        return testCases.get(type).stream().filter(testCase -> testCase.getId().equals(id)).findFirst();
    }

    public List<TestResult> getCompletedTestResults() {
        return completedTestResults;
    }

    public RunningTestResult getStateOfRunningTest() {
        switch (state) {
            case DONE:
                return new RunningTestResult(completedTestResults.get(completedTestResults.size() - 1), state);
            default:
            case RUNNING:
                return new RunningTestResult(null, state);
        }
    }
}
