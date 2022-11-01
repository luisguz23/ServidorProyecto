package com.example.servidorproyecto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Creacion del BubbleSort

/**
 * Se llama para realizar el ordenamiento por bubble.
 */
public class Bubble {
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add(1);
        list.add(6);
        list.add(3);
        list.add(4);
        list.add(45);
        list.add(6);
        list.add(234);
        list.add(8);
        list.add(9);

        bubbleSort(list);
        System.out.println(list);
    }

    /**
     * es el encargado de realizar el ordenamiento.
     * @param list bubblesort necesita recibir una lista de enteros para funcionar.
     */
    public static void bubbleSort(List<Integer> list) {

        int n = list.size();
        int temp = 0;

        for(int i = 0; i < n-1; i++) {
            for (int j = 0; j < (n - i - 1); j++) {

                if (list.get(j) > list.get(j+1)) {
                    temp = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1, temp);
                }

            }
        }
    }




    void eyou(){

    }
    void ajio(){

    }
    void epic(){

    }
}
//Obtenido https://stackoverflow.com/questions/47245619/java-bubblesort-algorithm-for-list