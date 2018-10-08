package com.hackernews.managers.service;

import com.hackernews.managers.service.request.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class ServiceManagerImp implements ServiceManager {

    private RequestHandler requestHandler;

    @Autowired
    public ServiceManagerImp(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public String getData(String url) throws IOException {
        InputStream response = requestHandler.getResponse(url);
        String content = getContent(response);

        return content;
    }

    private String getContent(InputStream response) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(response));

        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        reader.close();

        return result.toString();
    }

}
