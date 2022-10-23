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

    public static void main(String[] args) {
        Conexion comu= new Conexion();
        comu.iniciar();

        ArbolBinario arbol=new ArbolBinario();

        arbol.insertar(4,"Hola");
        arbol.insertar(8,"Prueba");
        arbol.insertar(1,"Hola");
        arbol.insertar(9,"Proyecto");
        arbol.insertar(7,"Xd");

        arbol.recorrer(arbol.root);
        System.out.println("------------------------------");
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.Lista();
        System.out.println("------------------------------");

        launch();
    }
}