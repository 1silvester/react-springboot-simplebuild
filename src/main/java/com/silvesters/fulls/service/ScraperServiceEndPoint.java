package com.silvesters.fulls.service;

import com.silvesters.fulls.model.Book;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class ScraperServiceEndPoint {

    @Autowired
    ScraperService scraperService;

    //search book by author name
    @RequestMapping(value = "/by-author/{authorName}", method = RequestMethod.GET, produces = "application/json")
    public List<Book> searchBookByAuthorName(@PathVariable("authorName") String authorName)
    {
        return scraperService.searchBookByAuthor(authorName);
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET, produces = "application/json")
    public List<String> listAuthors()
    {
        return scraperService.listAuthors();
    }

    @RequestMapping(value = "by-title/{title}", method = RequestMethod.GET,produces = "application/json")
    public List<Book> searchBookByTitle(@PathVariable("title") String title)
    {
        return scraperService.searchBookByTitle(title);
    }
}
