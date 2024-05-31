package com.personal.aggregator.config;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.personal.aggregator.model.GptQueryRequestDto;
import com.personal.aggregator.model.GptQueryResponse;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HttpService {

    private static final String CHAT_GPT_API = "https://api.openai.com/v1/completions";
    private static final String API_KEY = "";

    @Autowired
    private Gson gson;

    @Autowired
    private OkHttpClient okHttpClient;
    public GptQueryResponse getQuery(GptQueryRequestDto dto) {
        RequestBody body = RequestBody.create(
                gson.toJson(dto),
                MediaType.parse("application/json; charset=utf-8")
        );

        // Build the request
        Request request = new Request.Builder()
                .url(CHAT_GPT_API)
                .header("Authorization", "Bearer " + API_KEY)
                .post(body)
                .build();

        try{
            Response response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Parse the response
            String responseBody = response.body().string();
            JsonObject responseJson = JsonParser.parseString(responseBody).getAsJsonObject();
            String answer = responseJson.getAsJsonArray("choices")
                    .get(0).getAsJsonObject()
                    .get("text").getAsString();
            System.out.println(answer.trim());
            return new GptQueryResponse(answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
