package com.practice.collection.controller;

import com.practice.collection.service.CollectionInterfaceType;
import com.practice.collection.service.CollectionImplementationType;
import com.practice.collection.service.TestRunnerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestRunnerController {

    private TestRunnerService testRunnerService;

    public TestRunnerController(TestRunnerService testRunnerService) {
        this.testRunnerService = testRunnerService;
    }

    @RequestMapping("/")
    public ModelAndView renderPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        model.addObject("coreInterfaces", CollectionInterfaceType.values());
        model.addObject("collectionImplementations", CollectionImplementationType.values());
        return model;
    }

    @RequestMapping("/startTest", RequestMethod.GET, produces="application/json")
    @ResponseBody
    public ModelAndView renderPage(CollectionImplementationType implementationType) {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        model.addObject("coreInterfaces", CollectionInterfaceType.values());
        model.addObject("collectionImplementations", CollectionImplementationType.values());
        return model;
    }
}
