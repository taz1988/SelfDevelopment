package com.concurrent.controller;

import com.concurrent.service.TestExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {


    private TestExecutorService testExecutorService;

    @Autowired
    public MainController(TestExecutorService testExecutorService) {
        this.testExecutorService = testExecutorService;
    }

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("testCases", testExecutorService.getTestCases());
        return modelAndView;
    }
}
