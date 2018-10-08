package com.hackernews.converters;

import com.google.gson.Gson;

public class JsonConverterImp implements JsonConverter {
    private Gson gson;

    public JsonConverterImp() {
        gson = new Gson();
    }

    public <T> T fromJson(String json, Class<T> type) {
        return gson.fromJson(json, type);
    }

}
