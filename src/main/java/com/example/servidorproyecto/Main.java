package com.example.servidorproyecto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        Conexion comu= new Conexion();
        comu.iniciar();
        String message = comu.message;

        ArbolBinario arbol=new ArbolBinario();

        /*arbol.insertar("Luis");
        arbol.insertar("Chris");
        arbol.insertar("Zelda");
        arbol.insertar("Cuphead");
        arbol.insertar("Leon");*/
        System.out.println("Recorriendo inorden:");
        arbol.inorden();
        System.out.println("Recorriendo postorden:");
        arbol.postorden();
        System.out.println("Recorriendo preorden:");
        arbol.preorden();
        System.out.println("Busqueda "+message+":");
        System.out.println(arbol.existe(message)); // true
        //System.out.println(arbol.existe("Claire")); // false
        //System.out.println(arbol.existe("Zelda")); // true
        System.out.println("------------------------------");
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.Lista();
        System.out.println("------------------------------");

        launch();
    }
}