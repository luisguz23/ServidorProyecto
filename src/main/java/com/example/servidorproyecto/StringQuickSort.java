package com.example.servidorproyecto;

import java.util.ArrayList;
import java.util.List;

/**
 * Acomoda los archivos con el algoritmo Quicksort
 */

public class StringQuickSort {
    int length;

    /**
     * Names Array
     * Names es un array que sera usado para ordenar el array que necesitamos.
     */

    public List<String>names=new ArrayList<>();



    public void jiji(){

    }

    /**
     * Sort es el encargado de realizar el quicksort, el llama al resto de metodos para realizarlo.
     * @param array aqui se supone que lo que se va a recibir es un array, por lo que eso es el parametro.
     */
    void sort(List<String> array) {
        if (array == null || array.size() == 0) {
            return;
        }
        this.names = array;
        this.length = array.size();
        quickSort(0, length - 1);
        System.out.println("Feo"+names);
    }

    /**
     * quicksort se encarga de calcular el pivote, y de conocer los extremos y de hacer el recorrido de comparacion.
     * @param lowerIndex variable utilizada para conocer el indice menor.
     * @param higherIndex variable utilizada para conocer el indice mayor.
     */
    void quickSort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        String pivot = this.names.get(lowerIndex + (higherIndex - lowerIndex) / 2);

        while (i <= j) {
            while (this.names.get(i).compareToIgnoreCase(pivot) < 0) {
                i++;
            }

            while (this.names.get(j).compareToIgnoreCase(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                exchangeNames(i, j);
                i++;
                j--;
            }
        }
        //call quickSort recursively
        if (lowerIndex < j) {
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex);
        }
    }

    /**
     * exchangeNames cambia los nombres en los extremos si ve que uno es mayor o menor que el otro.
     * @param i extremo inferior
     * @param j extremo superior
     */

    void exchangeNames(int i, int j) {
        String temp = this.names.get(i);
        this.names.set(i, this.names.get(j));
        this.names.set(j, temp);
    }
}
//Obtenido de https://stackoverflow.com/questions/29294982/using-quicksort-on-a-string-array
