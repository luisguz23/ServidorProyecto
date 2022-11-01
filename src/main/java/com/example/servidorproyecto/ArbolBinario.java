package com.example.servidorproyecto;

/**
 * Crea un arbol binario
 */

public class ArbolBinario {
    Conexion conexion=new Conexion();

    //codigo tomado de: https://parzibyte.me/blog/2020/05/08/arbol-binario-java/#Busqueda_dentro_del_arbol

    private Nodo raiz;
    public ArbolBinario() {

    }

    /**
     * Metodo utilizado para saber si la palabra que se ingresa existe en cada uno de los archivos
     * @param busqueda la palabra que compara
     * @return un booleano
     */
    public boolean existe(String busqueda) {
        return existe(this.raiz, busqueda);
    }

    /**
     * con los datos que obtiene del publico, realiza la comparacion
     * @param n la palabra del archivo que analiza
     * @param busqueda parametro para recibir el mensaje a comparar
     * @return un booleano
     */
    private boolean existe(Nodo n, String busqueda) {

        if (n == null) {
            return false;
        }
        if (n.getDato().equals(busqueda)) {
            return true;
        } else if (busqueda.compareTo(n.getDato()) < 0) {
            return existe(n.getIzquierda(), busqueda);
        } else {
            return existe(n.getDerecha(), busqueda);
        }

    }

    /**
     * inserta los valores ya parseados de los documentos a un arbol
     * @param dato valor del parseo
     */
    public void insertar(String dato) {
        if (this.raiz == null) {
            this.raiz = new Nodo(dato);
            //System.out.println("AGREGADO "+dato);
        } else {
            this.insertar(this.raiz, dato);
            //System.out.println("AGREGADO "+dato);
        }
    }

    /**
     * Compara los datos para insertarlos en el arbol
     * @param padre valor con el que se compara
     * @param dato es el valor parseado
     */

    private void insertar(Nodo padre, String dato) {
        if (dato.compareTo(padre.getDato()) > 0) {
            if (padre.getDerecha() == null) {
                padre.setDerecha(new Nodo(dato));
            } else {
                this.insertar(padre.getDerecha(), dato);
            }
        } else {
            if (padre.getIzquierda() == null) {
                padre.setIzquierda(new Nodo(dato));
            } else {
                this.insertar(padre.getIzquierda(), dato);
            }
        }
    }

    /**
     * me devuelve el arbol en orden preordenado
     * @param n es el dato parseado
     */

    private void preorden(Nodo n) {
        if (n != null) {
            n.imprimirDato();
            preorden(n.getIzquierda());
            preorden(n.getDerecha());
        }
    }

    /**
     * es el arbol en inordenado
     * @param n es el dato parseado
     */
    private void inorden(Nodo n) {
        if (n != null) {
            inorden(n.getIzquierda());
            //n.imprimirDato();
            inorden(n.getDerecha());
            System.out.println(n.getDato());
        }
    }

    /**
     * es el arbol en postorden
     * @param n es el dato
     */

    private void postorden(Nodo n) {
        if (n != null) {
            postorden(n.getIzquierda());
            postorden(n.getDerecha());
            n.imprimirDato();
        }
    }

    public void preorden() {
        this.preorden(this.raiz);
    }

    public void inorden() {
        this.inorden(this.raiz);
    }

    public void postorden() {
        this.postorden(this.raiz);
    }
}


