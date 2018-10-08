package com.hackernews.managers.posts;

import com.hackernews.converters.JsonConverter;
import com.hackernews.managers.service.ServiceManager;
import com.hackernews.models.Post;
import com.hackernews.properties.PostPropertiesManager;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class PostManager {
    private static final String delimiter = ",";

    private PostPropertiesManager propertiesManager;
    private JsonConverter jsonConverter;
    private ServiceManager serviceManager;

    @Autowired
    public PostManager(PostPropertiesManager postPropertiesManager, JsonConverter jsonConverter,
                       ServiceManager serviceManager) {
        this.propertiesManager = postPropertiesManager;
        this.jsonConverter = jsonConverter;
        this.serviceManager = serviceManager;
    }

    public String getPosts(int postNumber) throws IOException {
        AtomicInteger index = new AtomicInteger();

        String posts = Arrays.stream(getPostIds())
                .limit(postNumber)
                .map((postId) -> fetchPost(postId))
                .map((post) -> AddRank(post, index))
                .map(Post::toString)
                .collect(Collectors.joining(delimiter + "\n"));

        return formatOutput(posts);
    }

    private String[] getPostIds() throws IOException {
        String url = propertiesManager.getLatestPostsUrl();
        String data = serviceManager.getData(url);
        int lastIndex = data.length() - 1;
        String[] postIds = data.substring(1, lastIndex).split(delimiter);

        return postIds;
    }

    private Post fetchPost(String postId) {
        Post post = null;

        try {
            String url = propertiesManager.getUrl(postId);
            String postJson = serviceManager.getData(url);
            post = jsonConverter.fromJson(postJson, Post.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return post;
    }

    private Post AddRank(Post post, AtomicInteger index) {
        post.setRank(index.incrementAndGet());

        return post;
    }

    private String formatOutput(String posts) {
        if (StringUtils.isNotEmpty(posts))
            posts = "[\n" + posts + "\n]";

        return posts;
    }

}