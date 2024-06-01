package com.personal.aggregator.controller;

import com.personal.aggregator.service.TestServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sample")
@Slf4j
public class TestController {

    @Autowired
    private TestServiceImpl testServiceImpl;

    @GetMapping(path = "/get")
    public String sampleApi() {
        log.info("sample get method");
        return "jinda hu main";
    }

    @PostMapping(path = "/post")
    public String sampleInsert() {
        testServiceImpl.test();
        return "post bhi jinda h";
    }
}
