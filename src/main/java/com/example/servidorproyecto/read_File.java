package com.example.servidorproyecto;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * LEE LOS TIPOS DE ARCHIVO
 */
// Main class
public class read_File {

    // codigo tomado de: https://es.acervolima.com/como-extraer-contenido-de-un-documento-de-texto-usando-java/#:~:text=Python%20JavaScript%20PHP-,¿Cómo%20extraer%20contenido%20de%20un%20documento%20de%20texto%20usando%20Java,leer%20el%20archivo%20de%20texto.
    //tambien se utilizó codigo de: https://es.stackoverflow.com/questions/99086/como-separar-una-cadena-string-por-espacios
    /**
     * dato es usado para recorrer
     */
    public String dato;
    //public String lio;
    //public String lio2;

    // Method 1
    // To read the file using Scanner

    /**
     * readUsingScanner es la encargada de parsear los documentos, llamar el arbol y ver si la palabra que se manda desde mensaje concuerda.
     * @param fileName es usada como una lista de archivos
     * @param message es el valor que se compara para ver si esta
     * @return debe devolver un string, que es el nombre del archivo
     * @throws Exception
     */
    public String readUsingScanner(String fileName, String message)
            throws Exception {

        // Again,  creating Path class object in main()
        // method

        List<String> listOfStrings
                = new ArrayList<String>();
        /*List<String> peter
                = new ArrayList<String>();*/
        /*peter.add("HelloWorld.txt");
        peter.add("LaVidaesDura.pdf");
        peter.add("lorem.txt");
        peter.add("Fuck.txt");*/


        Conexion conexion = new Conexion();
        conexion.iniciar();
        ArbolBinario arbol = new ArbolBinario();
        Biblioteca biblio = new Biblioteca();
        StringQuickSort quick = new StringQuickSort();
/**
 * item es utilizado para recorrer
 * NombreSolo es la variable para guardar el dato que se transfiere en el return
 * index1 es usado para poder obtener el nombre
 */
        String item;
        //String message= conexion.message;
        String NombreSolo = null;

        int index1 = fileName.lastIndexOf("\\");
        //System.out.println(fileName);
        if (index1 > 0) {
            String NombreSolo1 = fileName.substring(index1 + 1);
            //System.out.println("File Name: " + NombreSolo1);

            int index2 = NombreSolo1.lastIndexOf(".");
            String formato = null;
            if (index2 > 0) {
                formato = NombreSolo1.substring(index2 + 1);
                //System.out.println("File Format:" + formato);

            }
            //System.out.println(formato);

            //Se llaman los diferentes metodos para parsear archivos
            if (Objects.equals(formato, "txt")) {
                int cont = 0;

                // Creating Scanner class object to take input
                Scanner scanner = new Scanner(new FileReader(fileName))
                        .useDelimiter("[ . , ; ?!¡¿\'\"\\[\\]]+");


                // Now reading file line by line
                // using hasNextLine() method
                //System.out.println("Busqueda "+message);

                while (scanner.hasNextLine()) {

                    // Processing each line

                    item = scanner.next();

                    listOfStrings.add(item);

                }
                String[] array
                        = listOfStrings.toArray(new String[0]);
                /*String[] array2
                        = peter.toArray(new String[0]);*/

                // print each string in array
                for (String eachString : array) {
                    dato = eachString;
                    arbol.insertar(eachString);
                    //arbol.inorden();
                    //System.out.println("buscar: " + message);
                    //System.out.println(arbol.existe(message));
                    if (arbol.existe(message) == true) {
                        cont = cont + 1;
                        if (cont == 1) {
                            int index3 = fileName.lastIndexOf("\\");
                            //System.out.println(fileName);
                            if (index3 > 0) {
                                NombreSolo = fileName.substring(index3 + 1);
                                //System.out.println("File Name: " + NombreSolo);
                                //peter.add(NombreSolo);


                                //quick.sort(peter);
                                //System.out.println(peter);

                                System.out.println();


                            } else {
                                System.out.println("Estamos mamando");
                            }
                        }

                        // close() method is used to close all the read
                        // write connections
                        scanner.close();
                    }
                }
            } else if (Objects.equals(formato, "docx")) {
                //return word(fileName, message);
                //System.out.println("es un archivo word");

            } else if (Objects.equals(formato, "pdf")) {
                //pdf(fileName, message);
                return pdf(fileName, message);
                //System.out.println("es un archivo pdf");

            } else {
                System.out.println("No funka esta picha");
                System.out.println(formato);
            }
        }
        return NombreSolo;
    }

    /**
     * metodo usado para leer pdf y parsearlos y realizar la comparacion, pero con pdf
     * @param fileName el archivo que se esta leyendo en ese momento
     * @param message lo que se va a comparar
     * @return regresa un string que es el nombre del archivo
     * @throws IOException
     */
    public String pdf(String fileName, String message) throws IOException {
        Conexion conexion = new Conexion();
        conexion.iniciar();
        ArbolBinario arbol = new ArbolBinario();
        String NombreSolo = null;

        int cont = 0;

        List<String> listOfStrings
                = new ArrayList<String>();

        //Loading an existing document
        File file = new File(fileName);
        PDDocument document = PDDocument.load(file);

        //Instantiate PDFTextStripper class
        PDFTextStripper pdfStripper = new PDFTextStripper();

        //Retrieving text from PDF document
        String text = pdfStripper.getText(document);
        //System.out.println(text);
        String[] palabras = text.split("[ . , ; ?!¡¿\'\"\\[\\]]+");

        for (String item : palabras) {
            listOfStrings.add(item);

        }
        //System.out.println(item);
        String[] array
                = listOfStrings.toArray(new String[0]);

        // print each string in array
        //String NombreSolo = null;
        for (String eachString : array) {
            String dato = eachString;
            //System.out.println(dato);
            arbol.insertar(eachString);
            //arbol.inorden();
            //System.out.println("buscar: " + message);
            //System.out.println(arbol.existe(message));
            if (arbol.existe(message) == true) {
                cont = cont + 1;
                if (cont == 1) {
                    int index3 = fileName.lastIndexOf("\\");
                    //System.out.println(fileName);
                    if (index3 > 0) {
                        NombreSolo = fileName.substring(index3 + 1);
                        //System.out.println("File Name: " + NombreSolo);


                    } else {
                        System.out.println("Estamos mamando");
                    }

                }


                //Closing the document
                document.close();

            }
        }
        return NombreSolo;
    }

    /**
     * metodo utilizado para leer Docx, parsearlo y comparar si la palabra aparece
     * @param fileName archivo que se lee en ese momento
     * @param message lo que se compara
     * @return regresa un string que es el nombre
     * @throws Exception
     */

    public String word(String fileName, String message) throws Exception {
        Conexion conexion = new Conexion();
        conexion.iniciar();
        ArbolBinario arbol = new ArbolBinario();

        int cont = 0;
        String NombreSolo = null;
        XWPFDocument docx = new XWPFDocument(new FileInputStream(fileName));

        List<String> listOfStrings
                = new ArrayList<String>();

        //using XWPFWordExtractor Class
        XWPFWordExtractor we = new XWPFWordExtractor(docx);
        //System.out.println(we.getText());

        String prueba = we.getText().toString();
        String[] p = prueba.split("[ . , ; ?!¡¿\'\"\\[\\]]+");
        for (String item : p) {
            listOfStrings.add(item);

        }
        //System.out.println(item);
        String[] array
                = listOfStrings.toArray(new String[0]);

        // print each string in array
        for (String eachString : array) {
            String dato = eachString;
            //String dato = eachString;
            //System.out.println(dato);
            arbol.insertar(eachString);
            //arbol.inorden();
            //System.out.println("buscar: " + message);
            //System.out.println(arbol.existe(message));
            if (arbol.existe(message) == true) {
                cont = cont + 1;
                if (cont == 1) {
                    int index3 = fileName.lastIndexOf("\\");
                    //System.out.println(fileName);
                    if (index3 > 0) {
                        NombreSolo = fileName.substring(index3 + 1);;

                        //System.out.println("File Name: " + NombreSolo);


                    } else {
                        System.out.println("Estamos mamando");
                    }

                }


            }


        }
        return NombreSolo;
    }
}