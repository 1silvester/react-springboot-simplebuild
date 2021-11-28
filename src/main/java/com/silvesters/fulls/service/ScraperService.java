package com.silvesters.fulls.service;

import com.silvesters.fulls.model.Book;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public interface ScraperService {
    public void loadContents() throws MalformedURLException, IOException;
    public List<String> listAuthors();
    public List<Book> searchBookByAuthor(String authorName);
    public List<Book> searchBookByTitle(String title);
}

