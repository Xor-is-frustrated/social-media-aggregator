package com.personal.aggregator.service;

import com.personal.aggregator.ModelConstants;
import com.personal.aggregator.config.HttpService;
import com.personal.aggregator.model.GptQueryRequestDto;
import com.personal.aggregator.model.GptQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GptServiceImpl {
    @Autowired
    private HttpService httpService;
    public GptQueryResponse query(String question) {
        GptQueryRequestDto dto = new GptQueryRequestDto();
        dto.setQuery(question);
        dto.setMaxTokens(50);
        dto.setModel(ModelConstants.DAVINCI_MODEL);

        GptQueryResponse response = httpService.getQuery(dto);
        return response;
    }
}
