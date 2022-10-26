package com.example.servidorproyecto;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

// Main class
public class read_File {

    public String item;
    // Method 1
    // To read the file using Scanner
    public  void readUsingScanner(String fileName)
            throws IOException {

        // Again,  creating Path class object in main()
        // method
        Path path = Paths.get(fileName);

        String delimitadores = "[ .,;?!¡¿\'\"\\[\\]]+";
        ArbolBinario arbol = new ArbolBinario();

        // Creating Scanner class object to take input
        Scanner scanner = new Scanner(path);

        // Display message for readability
        //System.out.println("Read text file using Scanner");

        // Now reading file line by line
        // using hasNextLine() method
        while (scanner.hasNextLine()) {

            // Processing each line
            String[] line = scanner.nextLine().split(delimitadores);

            for (String item_aux : line) {
                item=item_aux;
                //arbol.insertar(item);
                System.out.println(item);
            }

            // Printing processed lines
            //System.out.println(line);
        }

        // close() method is used to close all the read
        // write connections
        scanner.close();
    }
}
