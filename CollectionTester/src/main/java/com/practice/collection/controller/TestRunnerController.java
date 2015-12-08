package com.practice.collection.controller;

import java.util.UUID;
import java.util.List;
import java.util.Map;
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
        model.addObject("testCases", testCases);
        return model;
    }

    @RequestMapping(value = "/startTest", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String renderPage(CollectionImplementationType implementationType, UUID id) {
        //testRunnerService.
        return "model";
    }
}
