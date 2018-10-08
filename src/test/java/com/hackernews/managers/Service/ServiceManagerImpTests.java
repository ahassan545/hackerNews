package com.hackernews.managers.Service;

import com.hackernews.managers.service.ServiceManagerImp;
import com.hackernews.managers.service.request.RequestHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class ServiceManagerImpTests {
    private static final String post = "{\"id\":12}";

    private RequestHandler requestHandler;
    private ServiceManagerImp serviceManager;

    @Before
    public void setUp() throws IOException {
        requestHandler = Mockito.mock(RequestHandler.class);

        when(requestHandler.getResponse(anyString())).thenReturn(new ByteArrayInputStream(post.getBytes()));

        serviceManager = new ServiceManagerImp(requestHandler);
    }

    @Test
    public void getData_returns_validPost() throws Exception {
        String result = serviceManager.getData("url");

        assertEquals(result, post);
    }

    @After
    public void tearDown() {
        requestHandler = null;
        serviceManager = null;
    }
}
