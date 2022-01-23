package com.silvesters.fulls.service;

import com.silvesters.fulls.model.Book;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

public interface ScraperService {
//    public void loadContents() throws MalformedURLException, IOException;
    public Map<String, String> listAuthors();
    public Map<String, String> searchBookByAuthor(String authorName);
    public Map<String, String> searchBookByTitle(String title);
//    public Map<String, String>
}

