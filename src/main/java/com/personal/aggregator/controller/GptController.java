package com.personal.aggregator.controller;

import com.personal.aggregator.model.GptQueryResponse;
import com.personal.aggregator.service.GptServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/gpt")
@Slf4j
public class GptController {
    @Autowired
    private GptServiceImpl gptService;
    @PostMapping(path = "/query")
    public GptQueryResponse queryGpt(@RequestBody String question){
        log.info("Query Request: " + question);
        return gptService.query(question);
    }
}
