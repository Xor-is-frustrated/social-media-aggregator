package com.personal.aggregator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GptQueryRequestDto {
    private String query;
    @JsonProperty("max_tokens")
    private Integer maxTokens;
    private String model;
}
