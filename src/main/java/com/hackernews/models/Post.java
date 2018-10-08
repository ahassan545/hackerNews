package com.hackernews.models;

public class Post {

    private String title;
    private String url;
    private int score;
    private String by;
    private int descendants;
    private int rank;

    public void setRank(int rank) {
        this.rank = rank;
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
}
