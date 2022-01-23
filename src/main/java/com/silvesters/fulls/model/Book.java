package com.silvesters.fulls.model;

public class Book {

    private String title;
    private String author;
    private String translator;
    private String dateWritten;
    private String linkToBrowse;


    public Book() {
    }

    public Book(String author, String linkToBrowse) {
        super();
        this.author = author;
        this.linkToBrowse = linkToBrowse;
    }

    public Book(String title, String author, String translator, String dateWritten) {
        super();
        this.title = title;
        this.author = author;
        this.translator = translator;
        this.dateWritten = dateWritten;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getDateWritten() {
        return dateWritten;
    }

    public void setDateWritten(String dateWritten) {
        this.dateWritten = dateWritten;
    }
}
