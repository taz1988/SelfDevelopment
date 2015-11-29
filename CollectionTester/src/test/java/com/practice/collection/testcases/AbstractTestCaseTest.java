package com.practice.collection.testcases;

import org.testng.annotations.Test;

import java.util.UUID;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AbstractTestCaseTest {

    private static String NAME = "dummy";
    private DummyTestCase testCase = new DummyTestCase();

    @Test
    public void testReturnProperValues() {
        TestResult testResult = testCase.run(2);

        assertTrue(testCase.isInitialized());
        assertEquals(testResult.getName(), NAME + "_2");
        assertEquals(testResult.getAverage(), 1.5);
        assertEquals(testResult.getDeviation(), 0.5);
        assertEquals(testResult.getMax(), 2);
        assertEquals(testResult.getMin(), 1);
    }



    private static class DummyTestCase extends AbstractTestCase {

        private boolean initialized;
        private long counter;

        @Override
        protected void init() {
            initialized = true;
        }

        @Override
        protected long run() {
            return ++counter;
        }

        @Override
        public UUID getId() {
            return null;
        }

        @Override
        public String getName() {
            return NAME;
        }

        public boolean isInitialized() {
            return initialized;
        }
    }

}