package com.hackernews.converters;

import com.hackernews.models.Post;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.apache.commons.lang.StringUtils.EMPTY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class JsonConverterImpTests {
    private JsonConverterImp converter;

    @Before
    public void setUp() {

        converter = new JsonConverterImp();
    }

    @Test(expected = Exception.class)
    public void fromJson_nullString_nullType_throwsException() throws Exception {
        converter.fromJson(null, null);
    }

    @Test
    public void fromJson_nullString_validType_returns_null() throws Exception {
        Post result = converter.fromJson(null, Post.class);

        assertNull(result);
    }

    @Test
    public void fromJson_emptyString_validType_returns_null() throws Exception {
        Post result = converter.fromJson(EMPTY, Post.class);

        assertNull(result);
    }

    @Test
    public void fromJson_validArguments_returns_validPost() throws Exception {
        String json = "{  \"by\" : \"bobby\",  \"descendants\" : 39,  \"score\" : 144,  \"title\" : " +
                "\"title\",  \"url\" : \"url\"}";

        String expectedPost = "{ \n" +
                "\"title\": \"title\",\n" +
                "\"uri\": \"url\",\n" +
                "\"author\": \"bobby\", \n" +
                "\"points\": 144,\n" +
                "\"comments\": 39,\n" +
                "\"rank\": 0\n" +
                "}";

        Post post = converter.fromJson(json, Post.class);


        assertEquals(post.toString(), expectedPost);
    }

    @After
    public void tearDown() {
        converter = null;
    }
}
