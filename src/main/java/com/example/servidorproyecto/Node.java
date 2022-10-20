package com.example.servidorproyecto;

public class Node {

    public int llave;
    public Node padre;
    public Node left;
    public Node right;
    public Object contenido;


    public Node(int indice){

        llave=indice;
        right=null;
        left=null;
        padre=null;
        contenido=null;
    }
}
