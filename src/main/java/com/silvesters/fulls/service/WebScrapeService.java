package com.silvesters.fulls.service;

import com.silvesters.fulls.model.Book;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WebScrapeService
        implements ScraperService
{
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());



    @Value("${classical.mit.url}")
    private String classicsUrl;

    @Value("${classical.mit.base}")
    private String baseUrl;

    @Value("${classical.mit.browse}")
    private String browseUrl;

    private Map<String, String> authors = new HashMap<>();

    private Map<String, String> booksAndLinks = new HashMap<>();

    private Map<String, String> books = new HashMap<>();
    @Override
    public Map<String,String> listAuthors() {
        System.out.println(classicsUrl);
        try {
            Document document = Jsoup.connect(classicsUrl).get();

            Elements body = document.select("a");

            for (Element l : body)
            {
                if (l.attr("target").equals("browse"))
                {
                    authors.put(l.text(), l.attr("href"));
                }
            }
        }
        catch (Exception exception){
            exception.printStackTrace();
        }

//      authors.forEach((k,v) -> System.out.println("key: "+ k + " value: "+ v));
        return authors;
    }


        @Override
    public Map<String, String> searchBookByAuthor(String authorName) {
//        Map<String, String> authorMap = listAuthors();
        String authorUrl = authors.get(authorName);

        String concatUrl = browseUrl + authorUrl;
        try
        {
            final Document document = Jsoup.connect(concatUrl).get();
            Elements body = document.select("a");
            for(Element b: body)
            {
                if(b.attr("target").equals("_parent"))
                {
                    booksAndLinks.put(b.text(), b.attr("href"));
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return booksAndLinks;
    }

    @Override
    public Map<String, String> searchBookByTitle(String title) {

        return null;
    }


    /*
    *
    * */




//    @Override
//    public void loadContents() throws MalformedURLException, IOException {
//
//    }

//    @Override
//    public Map<String,String> listAuthors() {
//        System.out.println(classicsUrl);
//        Map<String, String> authors = new HashMap<>();
//        try {
////            final Document document = Jsoup.connect(urlAuthor).get();
//            final Document document = Jsoup.connect(classicsUrl).get();
//            Elements e = document.getElementsByTag("meta");
//            e.forEach(System.out::println);
//            Elements body = document.select("a");
//            for (Element l : body)
//            {
//                if (l.attr("target").equals("browse"))
//                {
//                    authors.put(l.text(), l.attr("href"));
//
//                }
//            }
//        }
//        catch (Exception exception){
//            exception.printStackTrace();
//        }
//
////        getCollectionOfBooksByAuthor(authors.get("Homer"));
//
////      authors.forEach((k,v) -> System.out.println("key: "+ k + " value: "+ v));
//        return authors;
//    }
//
//    @Override
//    public Map<String, String> searchBookByAuthor(String authorName) {
//        return null;
//    }
//
//    @Override
//    public Map<String, String> searchBookByTitle(String title) {
//        return null;
//    }
}
