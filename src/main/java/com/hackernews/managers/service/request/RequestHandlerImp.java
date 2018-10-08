package com.hackernews.managers.service.request;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class RequestHandlerImp implements RequestHandler {

    public InputStream getResponse(String urlString) throws IOException {
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();

        return connection.getInputStream();
    }
}
