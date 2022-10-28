package com.example.servidorproyecto;

import java.io.FileInputStream;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

    public class WordExtractor {
        public static void main(String[] args)throws Exception {
            XWPFDocument docx = new XWPFDocument(new FileInputStream("Biblioteca/Por que.docx"));

            //using XWPFWordExtractor Class
            XWPFWordExtractor we = new XWPFWordExtractor(docx);
            System.out.println(we.getText());
        }
    }

//Obtenido de https://www.tutorialspoint.com/apache_poi_word/apache_poi_word_text_extraction.htm

