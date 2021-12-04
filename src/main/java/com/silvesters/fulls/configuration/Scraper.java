package com.silvesters.fulls.configuration;

import com.silvesters.fulls.service.ScraperService;
import com.silvesters.fulls.service.WebScrapeService;
import org.springframework.context.annotation.Bean;

import java.util.Map;

public class Scraper {

//    @Bean
//    public ScraperService ScraperServ()
//    {
//        return new ScraperService() {
//
//            @Override
//            public Map<String, String> listAuthors() {
//                return null;
//            }
//
//            @Override
//            public Map<String, String> searchBookByAuthor(String authorName) {
//                return null;
//            }
//
//            @Override
//            public Map<String, String> searchBookByTitle(String title) {
//                return null;
//            }
//        };
//    }

    @Bean
    public WebScrapeService webScrapeService()
    {
        return new WebScrapeService();
    }
}
