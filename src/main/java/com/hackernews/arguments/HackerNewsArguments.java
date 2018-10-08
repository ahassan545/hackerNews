package com.hackernews.arguments;

import com.github.jankroken.commandline.annotations.LongSwitch;
import com.github.jankroken.commandline.annotations.Option;
import com.github.jankroken.commandline.annotations.Required;
import com.github.jankroken.commandline.annotations.SingleArgument;
import org.apache.commons.lang3.math.NumberUtils;

public class HackerNewsArguments {
    private static final String longSwitchValue = "posts";

    private int postsNumber;

    public static String getDefaultMessage() {
        return "HackerNews Application \n" +
                "usage: hackernews --posts n\n\n" +
                "arguments: \n" +
                " --posts   how many posts to print. A positive integer <= 100. \n";
    }

    public int getPostsNumber() {
        return this.postsNumber;
    }

    @Option
    @LongSwitch(longSwitchValue)
    @SingleArgument
    @Required
    public void setPostsNumber(String postsNumber) throws Exception {
        this.postsNumber = getPostsNumber(postsNumber);
    }

    private int getPostsNumber(String postString) throws Exception {
        int postsNumber = NumberUtils.toInt(postString);

        if (!isValid(postsNumber))
            throw new Exception(getDefaultMessage());

        return postsNumber;
    }

    private boolean isValid(int posts) {
        return posts > 0 && posts <= 100;
    }
}
