package com.hackernews.models;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Post {
    private final String urlPatternString = ".*https?://.*";

    private String title;
    private String url;
    private int score;
    private String by;
    private int descendants;
    private int rank;

    public void setRank(int rank) {
        this.rank = rank;
    }

    public boolean isValid() {
        return isValidString(title)
                && isValidString(by)
                && score >= 0
                && descendants >= 0
                && rank >= 0
                && hasValidUrl(url);
    }

    public String toString() {
        return String.format("{ \n" +
                "\"title\": \"%s\",\n" +
                "\"uri\": \"%s\",\n" +
                "\"author\": \"%s\", \n" +
                "\"points\": %s,\n" +
                "\"comments\": %s,\n" +
                "\"rank\": %s\n" +
                "}", title, url, by, score, descendants, rank);
    }

    private boolean hasValidUrl(String url) {
        if(StringUtils.isEmpty(url))
            return false;

        Pattern pattern = Pattern.compile(urlPatternString);
        Matcher matcher = pattern.matcher(url);

        return matcher.matches();
    }

    private boolean isValidString(String value){
        return StringUtils.isNotEmpty(value) && value.length() <= 256;
    }
}
