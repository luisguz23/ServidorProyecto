package com.example.servidorproyecto;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

    public class ReadingText {

        public static void main(String args[]) throws IOException {

            List<String> listOfStrings
                    = new ArrayList<String>();

            //Loading an existing document
            File file = new File("Biblioteca/pruebapdf.pdf");
            PDDocument document = PDDocument.load(file);

            //Instantiate PDFTextStripper class
            PDFTextStripper pdfStripper = new PDFTextStripper();

            //Retrieving text from PDF document
            String text = pdfStripper.getText(document);
            //System.out.println(text);
            String[] palabras= text.split("[ . , ; ?!¡¿\'\"\\[\\]]+");

            for (String item: palabras){
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

            //Closing the document
            document.close();

        }
    }

//Obtenido de https://www.tutorialspoint.com/pdfbox/pdfbox_reading_text.htm

