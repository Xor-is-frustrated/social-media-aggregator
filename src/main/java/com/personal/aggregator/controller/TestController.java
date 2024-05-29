package com.personal.aggregator.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sample")
@Slf4j
public class TestController {

    @GetMapping(path = "/get")
    public String sampleApi() {
        log.info("info log test");
        log.debug("debug log test");
        log.error("error log test");
        return "jinda hu main";
    }
}
