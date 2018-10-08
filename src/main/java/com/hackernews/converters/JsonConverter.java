package com.hackernews.converters;

public interface JsonConverter {
    <T> T fromJson(String json, Class<T> type);
}
