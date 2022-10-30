package com.example.servidorproyecto;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main class
public class read_File {

    // codigo tomado de: https://es.acervolima.com/como-extraer-contenido-de-un-documento-de-texto-usando-java/#:~:text=Python%20JavaScript%20PHP-,¿Cómo%20extraer%20contenido%20de%20un%20documento%20de%20texto%20usando%20Java,leer%20el%20archivo%20de%20texto.
    //tambien se utilizó codigo de: https://es.stackoverflow.com/questions/99086/como-separar-una-cadena-string-por-espacios

    public String dato;

    // Method 1
    // To read the file using Scanner
    public void readUsingScanner(String fileName)
            throws IOException {

        // Again,  creating Path class object in main()
        // method
        List<String> listOfStrings
                = new ArrayList<String>();

        Conexion conexion = new Conexion();
        ArbolBinario arbol = new ArbolBinario();

        String item;
        String message= conexion.message;

        int cont = 0;

        // Creating Scanner class object to take input
        Scanner scanner = new Scanner(new FileReader(fileName))
                .useDelimiter("[ . , ; ?!¡¿\'\"\\[\\]]+");


        // Now reading file line by line
        // using hasNextLine() method
        while (scanner.hasNextLine()) {

            // Processing each line

            item = scanner.next();

            listOfStrings.add(item);

        }
        String[] array
                = listOfStrings.toArray(new String[0]);

        // print each string in array
        for (String eachString : array) {
            dato = eachString;
            arbol.insertar(eachString);
            //arbol.inorden();
            System.out.println(arbol.existe("Hola"));
            if (arbol.existe("Hola") == true) {
                cont = cont + 1;
                if (cont == 1) {
                    int index = fileName.lastIndexOf("\\");
                    //System.out.println(fileName);
                    if (index > 0) {
                        String NombreSolo = fileName.substring(index + 1);
                        System.out.println("File Name: " + NombreSolo);
                        //System.out.println("Funka?");
                        //System.out.println(eachString);
                    } else {
                        System.out.println("Estamos mamando");
                    }
                }

                // close() method is used to close all the read
                // write connections
                scanner.close();
            }
        }
    }
}
