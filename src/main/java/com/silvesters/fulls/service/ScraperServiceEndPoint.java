package com.silvesters.fulls.service;

import com.silvesters.fulls.configuration.Scraper;
import com.silvesters.fulls.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class ScraperServiceEndPoint {

//    @Autowired
//    Scraper scraperService;

    @Autowired(required = false)
    WebScrapeService webScrapeService;

    //search book by author name
    @RequestMapping(value = "/by-author/{authorName}", method = RequestMethod.GET, produces = "application/json")
    public Map<String, String> searchBookByAuthorName(@PathVariable("authorName") String authorName)
    {

//        return scraperService.ScraperServ().searchBookByAuthor(authorName);
        return webScrapeService.searchBookByAuthor(authorName);
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET, produces = "application/json")
    public List<String> listAuthors()
    {
//        return scraperService.ScraperServ().listAuthors();
        List<String> stringList = new ArrayList<>();

        webScrapeService.listAuthors().forEach((k,v) -> stringList.add(k));

        return stringList;
    }

    @RequestMapping(value = "by-title/{title}", method = RequestMethod.GET, produces = "application/json")
    public Map<String, String> searchBookByTitle(@PathVariable("title") String title)
    {
//        return scraperService.ScraperServ().searchBookByTitle(title);

        return null;
    }
}
