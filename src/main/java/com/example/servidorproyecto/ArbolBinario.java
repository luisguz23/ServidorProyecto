package com.example.servidorproyecto;


public class ArbolBinario {
    Node root;
    public ArbolBinario(){
        root=null;

    }

    public void insertar(int i, Object str){
        Node n= new Node(i);
        n.contenido=str;

        if (root==null){
            root=n;
        }
        else{
            Node aux = root;
            while (aux != null){
                n.padre=aux;
                if(n.llave >= aux.llave){
                    aux=aux.right;

                }else{

                    aux=aux.left;
                }

            }
            if (n.llave < n.padre.llave){
                n.padre.left=n;
            }else{
                n.padre.right=n;
            }
        }
    }

    public void recorrer(Node n){
        if (n != null){
            recorrer(n.left);
            System.out.println("Indice " +n.llave+" str"+n.contenido);
            recorrer(n.right);
        }

    }





}
