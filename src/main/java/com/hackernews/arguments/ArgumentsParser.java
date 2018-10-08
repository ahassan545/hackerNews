package com.hackernews.arguments;

import com.github.jankroken.commandline.CommandLineParser;
import com.github.jankroken.commandline.OptionStyle;

import java.lang.reflect.InvocationTargetException;

public class ArgumentsParser {

    public HackerNewsArguments parse(String[] args) throws IllegalAccessException
            , InvocationTargetException, InstantiationException {

        HackerNewsArguments arguments = CommandLineParser.parse(
                HackerNewsArguments.class, args, OptionStyle.LONG_OR_COMPACT);

        return arguments;
    }
}
