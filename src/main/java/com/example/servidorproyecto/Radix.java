package com.example.servidorproyecto;

import java.util.Arrays;
import java.util.Arrays;

/**
 * Clase usada para aplicar el algortimo radix
 */

public class Radix {


        public void mex(){

        }

       public void order(){

        }

        public void hey(){

        }

    /**
     * se encarga de realizar los cambios en el array
     * @param array de enteros
     * @param size un numero entero
     * @param place otro numero entero
     */
        // Using counting sort to sort the elements in the basis of significant places
        void countingSort(int array[], int size, int place) {
            int[] output = new int[size + 1];
            int max = array[0];
            for (int i = 1; i < size; i++) {
                if (array[i] > max)
                    max = array[i];
            }
            int[] count = new int[max + 1];

            for (int i = 0; i < max; ++i)
                count[i] = 0;

            // Calculate count of elements
            for (int i = 0; i < size; i++)
                count[(array[i] / place) % 10]++;

            // Calculate cumulative count
            for (int i = 1; i < 10; i++)
                count[i] += count[i - 1];

            // Place the elements in sorted order
            for (int i = size - 1; i >= 0; i--) {
                output[count[(array[i] / place) % 10] - 1] = array[i];
                count[(array[i] / place) % 10]--;
            }

            for (int i = 0; i < size; i++)
                array[i] = output[i];
        }

    /**
     * me consigue el elemento del maximo del array
     * @param array de enteros
     * @param n para comparar con el dato
     * @return el maximo
     */
        // Function to get the largest element from an array
        int getMax(int array[], int n) {
            int max = array[0];
            for (int i = 1; i < n; i++)
                if (array[i] > max)
                    max = array[i];
            return max;
        }

    /**
     * Funcion de paso de elementos al resto
     * @param array un array de enteros
     * @param size un numero que es el size del array
     */
        // Main function to implement radix sort
        void radixSort(int array[], int size) {
            // Get maximum element
            int max = getMax(array, size);

            // Apply counting sort to sort elements based on place value.
            for (int place = 1; max / place > 0; place *= 10)
                countingSort(array, size, place);
        }

    /**
     * main da los datos para el radix y llama metodos.
     * @param args ninguno
     */
        // Driver code
        public static void main(String args[]) {
            int[] data = { 121, 432, 564, 23, 1, 45, 788 };
            int size = data.length;
            Radix rs = new Radix();
            rs.radixSort(data, size);
            System.out.println("Sorted Array in Ascending Order: ");
            System.out.println(Arrays.toString(data));
        }
    }

//Obtenido de https://www.programiz.com/dsa/radix-sort