package com.practice.collection.testcases;

import org.testng.annotations.Test;

import java.util.UUID;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class AbstractTestCaseTest {

    private static String NAME = "dummy";
    private DummyTestCase testCase = new DummyTestCase();

    @Test
    public void testReturnProperValues() {
        TestResult testResult = testCase.run(2);

        assertEquals(testCase.getNumberOfInits(), 2);
        assertEquals(testCase.getNumberOfRuns(), 2);
        assertEquals(testResult.getName(), NAME + "_2");
        assertNotNull(testResult.getAverage());
        assertNotNull(testResult.getDeviation());
        assertNotNull(testResult.getMax());
        assertNotNull(testResult.getMin());
    }



    private static class DummyTestCase extends AbstractTestCase {

        private int intiCounter;
        private int counter;

        @Override
        protected void init() {
            intiCounter++;
        }

        @Override
        protected void run() {
            counter++;
        }

        @Override
        public UUID getId() {
            return null;
        }

        @Override
        public String getName() {
            return NAME;
        }

        public int getNumberOfInits() {
            return intiCounter;
        }

        public int getNumberOfRuns() {
            return counter;
        }
    }

}
