package com.hackernews.properties;

import java.io.IOException;

public class PostPropertiesManagerImp extends PropertiesManager implements PostPropertiesManager {
    private static final String configFileName = "hackerNews.properties";
    private static final String latestPostsUrl = "latestPostsUrl";
    private static final String postUrl = "postUrl";

    public PostPropertiesManagerImp() throws IOException {
        super(configFileName);
    }

    public String getLatestPostsUrl() {
        return getValue(latestPostsUrl);
    }

    public String getUrl(String postId) {
        return String.format(getValue(postUrl), postId.trim());
    }

}
