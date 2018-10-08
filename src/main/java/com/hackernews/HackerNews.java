package com.hackernews;

import com.hackernews.arguments.ArgumentsParser;
import com.hackernews.arguments.HackerNewsArguments;
import com.hackernews.managers.posts.PostManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationTargetException;

import static com.hackernews.arguments.HackerNewsArguments.getDefaultMessage;

public class HackerNews {

    private static PostManager postManager;
    private static ArgumentsParser parser;

    public static void main(String[] args) {
        try {
            initializeApp();

            int postNumber = getPostsNumber(args);
            String posts = postManager.getPosts(postNumber);

            System.out.println(posts);

        } catch (Exception e) {
            System.out.println(getDefaultMessage());
            System.out.println(e);
            System.exit(0);
        }
    }

    private static void initializeApp() {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(HackerNewsConfiguration.class);
        postManager = context.getBean(PostManager.class);
        parser = context.getBean(ArgumentsParser.class);
    }

    private static int getPostsNumber(String[] args) throws IllegalAccessException, InstantiationException,
            InvocationTargetException {
        HackerNewsArguments arguments = parser.parse(args);

        return arguments.getPostsNumber();
    }
}
