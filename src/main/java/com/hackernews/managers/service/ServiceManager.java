package com.hackernews.managers.service;

import java.io.IOException;

public interface ServiceManager {
    String getData(String url) throws IOException;
}
