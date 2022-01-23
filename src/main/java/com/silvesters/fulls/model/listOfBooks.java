package com.silvesters.fulls.model;

import java.util.Collections;
import java.util.List;

public class listOfBooks {
    private String author;
    private List<String> listOfWorks;

    public listOfBooks(){}

    public listOfBooks(String author, List<String> listOfWorks) {
        super();
        this.author = author;
        this.listOfWorks = listOfWorks;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getBrowseLink() {
        return listOfWorks;
    }

    public void setBrowseLink(List<String> listOfWorks) {
        this.listOfWorks = listOfWorks;
    }

    @Override
    public String toString() {
        return "BookLinks{" +
                "author='" + author + '\'' +
                ", listOfWorks='" + listOfWorks + '\'' +
                '}';
    }
}
