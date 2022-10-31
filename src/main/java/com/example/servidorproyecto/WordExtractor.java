package com.example.servidorproyecto;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

    public class WordExtractor {
        public static void main(String[] args)throws Exception {
            XWPFDocument docx = new XWPFDocument(new FileInputStream("Biblioteca/prueba.docx"));
            List<String> listOfStrings
                    = new ArrayList<String>();

            //using XWPFWordExtractor Class
            XWPFWordExtractor we = new XWPFWordExtractor(docx);
            //System.out.println(we.getText());

            String prueba = we.getText().toString();
            String[] p = prueba.split("[ . , ; ?!¡¿\'\"\\[\\]]+");
            for (String item: p){
                listOfStrings.add(item);

            }
                //System.out.println(item);
                String[] array
                        = listOfStrings.toArray(new String[0]);

                // print each string in array
                for (String eachString : array) {
                    String dato = eachString;
                    System.out.println(dato);
            }




        }
    }

//Obtenido de https://www.tutorialspoint.com/apache_poi_word/apache_poi_word_text_extraction.htm

