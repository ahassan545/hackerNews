package com.hackernews.managers.service.request;

import java.io.IOException;
import java.io.InputStream;

public interface RequestHandler {
    InputStream getResponse(String urlString) throws IOException;
}
