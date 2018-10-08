package com.hackernews;

import com.hackernews.arguments.ArgumentsParser;
import com.hackernews.converters.JsonConverter;
import com.hackernews.converters.JsonConverterImp;
import com.hackernews.managers.service.request.RequestHandler;
import com.hackernews.managers.service.request.RequestHandlerImp;
import com.hackernews.properties.PostPropertiesManager;
import com.hackernews.properties.PostPropertiesManagerImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@ComponentScan(value = {"com.hackernews"})
public class HackerNewsConfiguration {

    @Bean
    public ArgumentsParser getArgumentsParser() {
        return new ArgumentsParser();
    }

    @Bean
    public JsonConverter getJsonConverter() {
        return new JsonConverterImp();
    }

    @Bean
    public PostPropertiesManager getPostPropertiesManager() throws IOException {
        return new PostPropertiesManagerImp();
    }

    @Bean
    public RequestHandler getRequestHandler() {
        return new RequestHandlerImp();
    }
}
