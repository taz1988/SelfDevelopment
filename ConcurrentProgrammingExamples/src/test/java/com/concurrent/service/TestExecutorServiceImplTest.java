package com.concurrent.service;

import com.concurrent.modell.StatusAndLog;
import com.concurrent.testCases.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Collections;
import java.util.UUID;

import static com.concurrent.modell.StatusAndLog.Status.NOT_RUNNING;
import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestExecutorServiceImplTest {

    private static final String TEST_NAME = "Test name";
    @Mock
    private TestCase testCase;
    @Mock
    private LogService logService;
    private TestExecutorService testExecutorService;
    private StatusAndLog progress;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        givenATestCase();
        testExecutorService = new TestExecutorServiceImpl(logService);
        ReflectionTestUtils.setField(testExecutorService, "testCases", asList(testCase));
    }

    @Test
    public void shouldStartTestCaseIfExist() {
        whenExecuteTestCase();
        thenTestCaseShouldExecuted();
    }

    @Test
    public void shouldReturnNotRunningStateIfTestNotRunning() {
        whenGetStatus();
        thenStatusShouldBeNotRunningAndLogEmpty();
    }

    private void thenStatusShouldBeNotRunningAndLogEmpty() {
        assertEquals(NOT_RUNNING, progress.getStatus());
        assertEquals(Collections.emptyList(), progress.getLogMessages());
    }

    private void whenGetStatus() {
        progress = testExecutorService.getProgress();
    }

    private void givenATestCase() {
        when(testCase.getName()).thenReturn(TEST_NAME);
    }

    private void whenExecuteTestCase() {
        testExecutorService.executeTest(TEST_NAME);
    }

    private void thenTestCaseShouldExecuted() {
        verify(testCase).execute();
    }

}