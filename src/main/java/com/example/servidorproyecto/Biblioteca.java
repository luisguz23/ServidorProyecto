package com.example.servidorproyecto;


import java.io.File;
import java.util.ArrayList;

public class Biblioteca {
    private File directory;
    private File[] files;
    private ArrayList<File> documentos;
    private int numerodocu;

    public void arreglo(){
        documentos= new ArrayList<File>();
        directory = new File("Biblioteca");
        files = directory.listFiles();

        if(files != null){
            for(File file: files){
                documentos.add(file);
                System.out.println(file);
            }
        }

    }
}
