package com.hackernews.managers.posts;

import com.hackernews.converters.JsonConverter;
import com.hackernews.managers.service.ServiceManager;
import com.hackernews.models.Post;
import com.hackernews.properties.PostPropertiesManager;
import org.apache.commons.lang.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class PostManagerTests {
    private static final String postString = "post string";

    private JsonConverter jsonConverter;
    private PostPropertiesManager postPropertiesManager;
    private ServiceManager serviceManager;
    private PostManager postManager;

    @Before
    public void setUp() throws IOException {
        serviceManager = Mockito.mock(ServiceManager.class);
        jsonConverter = Mockito.mock(JsonConverter.class);
        postPropertiesManager = Mockito.mock(PostPropertiesManager.class);
        Post post = Mockito.mock(Post.class);

        when(post.isValid()).thenReturn(true);
        when(post.toString()).thenReturn(postString);
        when(serviceManager.getData(anyString())).thenReturn("data");
        when(jsonConverter.fromJson(Mockito.any(String.class), Mockito.any(Class.class))).thenReturn(post);

        postManager = new PostManager(postPropertiesManager, jsonConverter, serviceManager);
    }

    @Test
    public void getPosts_zero_returns_emptyString() throws Exception {
        String result = postManager.getPosts(0);

        assertEquals(result, StringUtils.EMPTY);
    }

    @Test
    public void getPosts_one_returns_validString() throws Exception {
        String result = postManager.getPosts(1);

        assertEquals(result, getExpectedResult(1));
    }

    @Test
    public void getPosts_two_returns_validString() throws Exception {
        when(serviceManager.getData(anyString())).thenReturn("data, data");

        String result = postManager.getPosts(2);

        assertEquals(result, getExpectedResult(2));
    }

    @After
    public void tearDown() {
        postManager = null;
        jsonConverter = null;
        serviceManager = null;
        postPropertiesManager = null;
    }


    private String getExpectedResult(int postNumber) {
        String expectedResult = StringUtils.EMPTY;

        for (int i = 0; i < postNumber; i++) {
            expectedResult += postString ;

            if (i < postNumber - 1)
                expectedResult += ",\n";
        }

        expectedResult = "[\n" + expectedResult + "\n]";

        return expectedResult;
    }
}
