package com.hackernews.arguments;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ArgumentsParserTests {
    private static final String postsNumber = "12";
    private static final String postsFlag = "--posts";

    private ArgumentsParser parser;

    @Before
    public void setUp() {

        parser = new ArgumentsParser();
    }

    @Test(expected = Exception.class)
    public void parse_null_throwsException() throws Exception {
        parser.parse(null);
    }

    @Test(expected = Exception.class)
    public void parse_emptyArray_throwsException() throws Exception {
        parser.parse(new String[]{});
    }

    @Test(expected = Exception.class)
    public void parse_invalidArguments_throwsException() throws Exception {
        parser.parse(new String[]{postsNumber});
    }

    @Test
    public void parse_validArguments_returns_validPostNumber() throws Exception {
        HackerNewsArguments expectedArgs = new HackerNewsArguments();
        expectedArgs.setPostsNumber(postsNumber);

        HackerNewsArguments resultArgs = parser.parse(new String[]{postsFlag, postsNumber});

        assertEquals(resultArgs.getPostsNumber(), expectedArgs.getPostsNumber());
    }

    @After
    public void tearDown() {
        parser = null;
    }
}
