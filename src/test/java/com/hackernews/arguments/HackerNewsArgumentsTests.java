package com.hackernews.arguments;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class HackerNewsArgumentsTests {
    private HackerNewsArguments arguments;

    @Before
    public void setUp() {

        arguments = new HackerNewsArguments();
    }

    @Test(expected = Exception.class)
    public void setPostsNumber_null_throwsException() throws Exception {
        arguments.setPostsNumber(null);
    }

    @Test(expected = Exception.class)
    public void setPostsNumber_emptyString_throwsException() throws Exception {
        arguments.setPostsNumber(EMPTY);
    }

    @Test
    public void setPostsNumber_validString_returns_validPostNumber() throws Exception {
        arguments.setPostsNumber("12");

        int posts = arguments.getPostsNumber();

        assertEquals(posts, 12);
    }

    @After
    public void tearDown() {
        arguments = null;
    }
}
