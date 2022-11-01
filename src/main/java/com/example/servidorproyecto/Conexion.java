package com.example.servidorproyecto;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * clase que establece la conexion con la clase conexion del cliente.
 */
public class Conexion {
    ServerSocket server;
    Socket socket;
    int puerto=9000;
    DataOutputStream salida;
    BufferedReader entrada;
    Biblioteca lib= new Biblioteca();
    public String message;

    //Código tomado de: https://www.youtube.com/watch?v=tsr53-zO73o

    /**
     *realiza conexion entre el cliente y el servidor
     */
    public void iniciar(){
        StringQuickSort qsort= new StringQuickSort();

        try {
            server=new ServerSocket(puerto);
            socket=new Socket();
            socket=server.accept();

            entrada=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            message= entrada.readLine();
            //System.out.println(message);
            salida=new DataOutputStream(socket.getOutputStream());
            List<String>prueba = new ArrayList<>();
            prueba.add("Hola");
            prueba.add("mundo");
            prueba.add("alv");
            //salida.writeUTF("Adios Mundo");
            salida.writeUTF(prueba.toString());
            socket.close();
        }catch (Exception e){}
    }
}
