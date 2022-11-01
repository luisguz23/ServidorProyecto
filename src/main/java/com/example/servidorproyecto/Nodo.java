package com.example.servidorproyecto;

/**
 * Clase usada para asignar valores en el recorrido del arbol.
 */

public class Nodo {

    private String dato;
    private Nodo izquierda, derecha;

    public Nodo(String dato) {
        this.dato = dato;
        this.izquierda = this.derecha = null;
    }

    /**
     * metodo usado para obtener el dato en ese momento, sin no imprimirlo
     * @return retorna el valor del dato
     */
    public String getDato() {
        return dato;
    }

    /**
     * metodo usado para obtener la izquierda del dato
     * @return un valor
     */
    public Nodo getIzquierda() {
        return izquierda;
    }

    /**
     * define la izquierda del dato
     * @param izquierda va a ser un valor
     */

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    /**
     * utilizado para obtener la derecha del dato
     * @return un valor
     */

    public Nodo getDerecha() {
        return derecha;
    }

    /**
     * me define la derecha del dato
     * @param derecha un valor
     */

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    /**
     * me devuelve el valor del dato
     */

    public void imprimirDato() {
        System.out.println(this.getDato());
    }
}
