package com.practice.collection.service;

import com.practice.collection.testcases.RunningTestResult;
import com.practice.collection.testcases.TestCase;
import com.practice.collection.testcases.TestResult;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.UUID;

import static com.practice.collection.service.CollectionImplementationType.ARRAY_LIST;
import static com.practice.collection.testcases.RunningTestResult.RunningState.DONE;
import static com.practice.collection.testcases.RunningTestResult.RunningState.RUNNING;
import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestRunnerServiceTest {

    private static final java.util.UUID ID = UUID.randomUUID();
    private static final int NUMBER_OF_RUNS = 10;
    private TestResult TEST_RESULT = new TestResult("test", 0, 0, 0, 0, 0);
    @Mock
    private TestCase testCase;
    private TestRunnerService testRunnerService;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.initMocks(this);
        testRunnerService = new TestRunnerService(Collections.singletonMap(ARRAY_LIST, asList(testCase)));
        when(testCase.getId()).thenReturn(ID);
    }

    @Test
    public void testServiceStartTheProperTestCase() {
        testRunnerService.start(ARRAY_LIST, ID, NUMBER_OF_RUNS);
        when(testCase.run(NUMBER_OF_RUNS)).thenReturn(TEST_RESULT);

        verify(testCase).run(NUMBER_OF_RUNS);
        assertTrue(testRunnerService.getCompletedTestResults().contains(TEST_RESULT));
    }
    
    @Test
    public void getStateOfRunningTestReturnInProgressIfThreadRunning() {
        ReflectionTestUtils.setField(testRunnerService, "state", RUNNING);
        RunningTestResult runningTestResult = testRunnerService.getStateOfRunningTest();
        assertEquals(runningTestResult.getState(), RUNNING);
    }

    @Test
    public void getStateOfRunningTestReturnInDoneIfThreadFinished() {
        ReflectionTestUtils.setField(testRunnerService, "state", DONE);
        testRunnerService.getCompletedTestResults().add(TEST_RESULT);
        RunningTestResult runningTestResult = testRunnerService.getStateOfRunningTest();
        assertEquals(runningTestResult.getState(), DONE);
        assertEquals(runningTestResult.getTestResult(), TEST_RESULT);
    }
}