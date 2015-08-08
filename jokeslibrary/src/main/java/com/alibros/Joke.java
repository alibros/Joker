package com.alibros;

public class Joke {

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Joke(String content) {

        this.content = content;
    }

    private String content;

}
