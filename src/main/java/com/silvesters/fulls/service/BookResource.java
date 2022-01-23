package com.silvesters.fulls.service;


import com.silvesters.fulls.texttime.TimeType;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.silvesters.fulls.texttime.TextTime;



@RestController
public class BookResource {

    @GetMapping("/api/book/marcus")
    public static String getBook(String book) throws IOException {
    File file = new File("src/main/resources/SodaPDF-converted-meditations.pdf");
    FileInputStream fis = new FileInputStream(file);

    PDDocument pdDocument = PDDocument.load(fis);
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    String docText = pdfTextStripper.getText(pdDocument);
    TextTime textTime = new TextTime(docText);
    System.out.println("word count is " + textTime.wordCount());
    System.out.println("It will take " + textTime.readTimeHuman(TimeType.FULL) + " to read it");
    System.out.println("To read for "+ String.valueOf(10) + " minutes The word count is " + textTime.calculateWordCountFromMinutes(10));
    StringBuilder stringBuilder = new StringBuilder();
//    textTime.checkTextEndsInFullStop(stringBuilder,textTime.calculateWordCountFromMinutes(10));
    stringBuilder.append(docText);

    pdDocument.close();
    fis.close();

//    return stringBuilder.substring(302,679);
      return stringBuilder.substring(302,textTime.calculateWordCountFromMinutes(10));
    }

//    @GetMapping("api/book/marcus/{time}")
//    public static String get5minBookRead(@PathVariable("time") Integer time) throws IOException
//    {
//        File file = new File("src/main/resources/SodaPDF-converted-meditations.pdf");
//        FileInputStream fis = new FileInputStream(file);
//
//        PDDocument pdDocument = PDDocument.load(fis);
//        PDFTextStripper pdfTextStripper = new PDFTextStripper();
//        String docText = pdfTextStripper.getText(pdDocument);
//        TextTime textTime = new TextTime(docText);
//        System.out.println("word count is " + textTime.wordCount());
//        System.out.println("It will take " + textTime.readTimeHuman(TimeType.FULL) + " to read it");
//        System.out.println("To read for "+ String.valueOf(time) + " minutes The word count is " + textTime.calculateWordCountFromMinutes(time));
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(docText);
////        textTime.checkTextEndsInFullStop(stringBuilder,textTime.calculateWordCountFromMinutes(time));
//        pdDocument.close();
//        fis.close();
//
////    return stringBuilder.substring(302,679);
//        return stringBuilder.substring(302,textTime.calculateWordCountFromMinutes(time));
//    }

//    @GetMapping("api/book/marcus/5-min")
//    public static String get5minRead(String s)
//    {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(s);
//        System.out.println(stringBuilder);
//        return stringBuilder.substring(0,1).toString();
//    }



}
