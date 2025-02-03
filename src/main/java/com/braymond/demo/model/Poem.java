package com.braymond.demo.model;

import lombok.Data;

@Data
public class Poem {

    private String title;
    private String author;
    private String content;

    @Override
    public String toString() {
        return "Poem{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}