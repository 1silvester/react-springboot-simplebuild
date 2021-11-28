package com.silvesters.fulls.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


@RestController
public class BookResource {

    @GetMapping("/api/book/marcus")
    public static String getBook(String book) throws IOException {
    File file = new File("src/main/resources/SodaPDF-converted-meditations.pdf");
    FileInputStream fis = new FileInputStream(file);

    PDDocument pdDocument = PDDocument.load(fis);
    PDFTextStripper pdfTextStripper = new PDFTextStripper();
    String docText = pdfTextStripper.getText(pdDocument);
//    System.out.println(docText);
    pdDocument.close();
    fis.close();

    return docText;
    }



}
