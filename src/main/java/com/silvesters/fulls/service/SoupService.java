package com.silvesters.fulls.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class SoupService {

    public static void main(String[] args){
    final String url = "http://classics.mit.edu/Browse/index.html";

    try {
        final Document document = Jsoup.connect(url).get();
        Elements body = document.select("frame");


//        Elements links = document.select("a[href]");

        for(Element b :  body){
        System.out.println(b.attr("src"));
        if (b.attr("name").equals("authors")){
            getAuthors(b.attr("src"));
        }
        }

    }catch (Exception e){System.err.println(e.getCause());}
    }

    public static void getAuthors(String url) {
        String urlAuthor = "http://classics.mit.edu/" + url;
        try {
            final Document document = Jsoup.connect(urlAuthor).get();
            Elements body = document.select("a");
            for (Element l : body) {
//                System.out.println(l);
                if (l.attr("target").equals("browse")) {
                    System.out.println(l.text());
                    System.out.println(l.attr("href"));
                }

            }
        } catch (Exception e) {
            System.err.println(e.getCause());
        }
    }

}
