package com.silvesters.fulls.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//@Service
public class SoupService {

    private Map<String, String> authors = new HashMap<>();


    public static void main(String[] args){
//    final String url = "http://classics.mit.edu/Browse/index.html";
//
//    try {
//        final Document document = Jsoup.connect(url).get();
//        Elements body = document.select("frame");
//
//        Elements links = document.select("a[href]");
//        for(Element b :  body){
//        System.out.println(b.attr("src"));
//        if (b.attr("name").equals("authors")){
//            getAuthors(b.attr("src"));
//        }
//        }
//    }
//    catch (Exception e){
//        e.printStackTrace();
//    }
        String url = "http://classics.mit.edu//Browse/authors.html";
        getAuthors(url);

    }

//    @Value("http://classics.mit.edu//Browse/authors.html")
//    private static String url;
    public static Map<String, String> getAuthors(String url) {

//        String urlAuthor = "http://classics.mit.edu/" + url;
//        System.out.println(urlAuthor);
//       String s = url;
        System.out.println(url);
        Map<String, String> authors = new HashMap<>();
        try {
            final Document document = Jsoup.connect(url).get();
//            final Document document = Jsoup.connect(String.valueOf(url)).get();
//            Elements e = document.getElementsByTag("meta");
//            e.forEach(System.out::println);
            Elements body = document.select("a");
            for (Element l : body)
            {
                if (l.attr("target").equals("browse"))
                {
                    authors.put(l.text(), l.attr("href"));
//                    System.out.println(l);
                }
            }
        }
        catch (Exception exception){
            exception.printStackTrace();
        }

        getCollectionOfBooksByAuthor(authors.get("Homer"));

//      authors.forEach((k,v) -> System.out.println("key: "+ k + " value: "+ v));
      /*
      * url http://classics.mit.edu//Browse/authors.html
      * returns key: Sa'di value: browse-Sadi.html
      * */
        return authors;

    }

//TODO
    /*This needs to be the first call to the website I make show the user author names and let them select
    then i can make the call for that specific author.
     */
    /*
    * This method takes and author name and uses the name to retrieve a link from a hashmap
    * The link is used to retrieve the books by the author and links to the books. Which are then placed in a
    * hashMap
    *
    * */

    public static void getCollectionOfBooksByAuthor(String authorName){
//        Map<String, String> authorLinkMap = getAuthors(url);
//        Map<String, String> authorLinkMap = url.stream().map()
        Map<String, String> booksAndLinks = new HashMap<>();
        /*
        * This is currently using the link directly and need to make it access it through the hashmap key
        * */

        String urlAuthor = "http://classics.mit.edu/Browse/" + authorName;
        System.out.println(urlAuthor);
        try {
            final Document document = Jsoup.connect(urlAuthor).get();
            Elements body = document.select("a");

            for (Element b : body)
            {
                if (b.attr("target").equals("_parent"))
                {
//                    System.out.print(b.text() +"   " +b.attr("href") + "\n");
                    booksAndLinks.put(b.text(), b.attr("href"));
//                    if (b.attr("a").contains("Written "))
//                    {
//                        System.out.println(b.text()+ " " +b.attr("href"));
//                        booksAndLinks.put(b.text(), b.attr("href"));
//                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
//        booksAndLinks.forEach((k,v) -> System.out.println("key " + k + " value " +v));

        getBookByTitle(booksAndLinks.get("The Iliad"));

        /*
       * http://classics.mit.edu/Browse/browse-Homer.html
        * returns key: Homeric Hymns value: /Homer/hh.1.html
        * */
    }

    public static void getBookByTitle(String title)
    {
        String urlTitle = "http://classics.mit.edu/" + title;
//        System.out.println(urlTitle);
        Map<String, String> getBookByTitle = new HashMap<>();
//        Map<String, HashMap<String, String>> getBookByTitle = new HashMap<>();
        try {
            final Document document = Jsoup.connect(urlTitle).get();
            Elements body = document.select("blockquote");
            Elements tables = body.select("table");
            Elements table = tables.select("a");
            for (Element td : table){
                getBookByTitle.put(td.text(), td.attr("href"));
//                System.out.print(td.text() + " " + td.attr("href")+ "\n");
            }
        }
        catch (Exception exception){
            exception.printStackTrace();
        }

        getBookLinkToTextFile(getBookByTitle.get("Book I"));

        /*
        url http://classics.mit.edu/
        * returns Book:  XXIV  extension: iliad.24.xxiv.html
        * */

    }

    public static void getBookLinkToTextFile(String textLink)
    {
        String urlPart = "http://classics.mit.edu/Homer/" +textLink;
//        System.out.println(urlPart);
        try {
            final Document document = Jsoup.connect(urlPart).get();
            Elements body = document.select("blockquote");
//            Elements text = body.select("b");
//            Elements links = text.select("a");
//            for(Element l : links)
//            {
//                System.out.println(l.attr("href"));
//            }
            for (Element b : body)
            {
//                System.out.println(b.select("a").attr("href"));
                getBookText(b.select("a").attr("href"));
//                System.out.println(b);
            }
        }
        catch (Exception exception){
           exception.printStackTrace();
        }

        /*
        * url: http://classics.mit.edu/Homer/iliad.1.i.html
        * returns: iliad.mb.txt
        *
        * */

    }

    public static void getBookText(String url)
    {
        String urlPart = "http://classics.mit.edu/Homer/" + url;
        System.out.println(urlPart);

        try {
            final Document document = Jsoup.connect(urlPart).get();
            Elements body = document.select("body");
//            System.out.println(body);

        }catch
        (Exception e)
        {
            e.printStackTrace();
        }
    }

    /*
    * url : http://classics.mit.edu/Homer/iliad.mb.txt
    * returns: text
    * */

}
