package com.example.servidorproyecto;

import java.util.ArrayList;
import java.util.List;

public class StringQuickSort {
    int length;

    public List<String>names=new ArrayList<>();



    public void jiji(){

    }


    void sort(List<String> array) {
        if (array == null || array.size() == 0) {
            return;
        }
        this.names = array;
        this.length = array.size();
        quickSort(0, length - 1);
        System.out.println("Feo"+names);
    }

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

    void exchangeNames(int i, int j) {
        String temp = this.names.get(i);
        this.names.set(i, this.names.get(j));
        this.names.set(j, temp);
    }
}
//Obtenido de https://stackoverflow.com/questions/29294982/using-quicksort-on-a-string-array
