package com.example.servidorproyecto;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion {
    ServerSocket server;
    Socket socket;
    int puerto=9000;
    DataOutputStream salida;
    BufferedReader entrada;
    public String message;

    //Código tomado de: https://www.youtube.com/watch?v=tsr53-zO73o

    /**
     *realiza conexion entre el cliente y el servidor
     */
    public void iniciar(){


        try {
            server=new ServerSocket(puerto);
            socket=new Socket();
            socket=server.accept();

            entrada=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            message= entrada.readLine();
            //System.out.println(message);
            salida=new DataOutputStream(socket.getOutputStream());
            salida.writeUTF("Adios Mundo");
            socket.close();
        }catch (Exception e){}
    }
}
