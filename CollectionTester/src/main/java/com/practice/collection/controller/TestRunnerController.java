package com.practice.collection.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.practice.collection.model.TestCaseDisplayModel;
import com.practice.collection.service.CollectionInterfaceType;
import com.practice.collection.service.CollectionImplementationType;
import com.practice.collection.service.TestRunnerService;
import com.practice.collection.testcases.TestCase;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestRunnerController {

    private static final Gson GSON = new Gson();
    private Map<CollectionImplementationType, List<TestCase>> testCases;
    private TestRunnerService testRunnerService;

    public TestRunnerController(TestRunnerService testRunnerService, Map<CollectionImplementationType, List<TestCase>> testCases) {
        this.testRunnerService = testRunnerService;
        this.testCases = testCases;
    }

    @RequestMapping("/")
    public ModelAndView renderPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        model.addObject("coreInterfaces", CollectionInterfaceType.values());
        model.addObject("collectionImplementations", CollectionImplementationType.values());
        model.addObject("testCases", convertTestCases());
        return model;
    }

    private List<TestCaseDisplayModel> convertTestCases() {
        List<TestCaseDisplayModel> testCaseDisplayModelList = new ArrayList<>();
        for (Map.Entry<CollectionImplementationType, List<TestCase>> cases : testCases.entrySet()) {
            for (TestCase testCase : cases.getValue()) {
                testCaseDisplayModelList.add(new TestCaseDisplayModel(testCase.getId().toString(), testCase.getName(), cases.getKey().name()));
            }
        }
        return testCaseDisplayModelList;
    }

    @RequestMapping(value = "/startTest", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String startTest(CollectionImplementationType implementationType, String id, int numberOfRuns) {
        testRunnerService.start(implementationType, UUID.fromString(id), numberOfRuns);
        return GSON.toJson(testRunnerService.getStateOfRunningTest());
    }

    @RequestMapping(value = "/getStatusOfRunningTest", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getStateOfRunningTest() {
        return GSON.toJson(testRunnerService.getStateOfRunningTest());
    }
}
