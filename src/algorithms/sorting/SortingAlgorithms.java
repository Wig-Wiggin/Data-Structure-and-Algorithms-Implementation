package algorithms.sorting;

import java.util.Arrays;

public class SortingAlgorithms {

    public static int[] selectionSort(int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (temp[i] > temp[j]) {
                    int x = temp[i];
                    temp[i] = temp[j];
                    temp[j] = x;
                }
            }
        }

        return temp;
    }



    public static int[] bubbleSort(int[] array) {
        if (array.length <= 1) return array;

        int[] arr = Arrays.copyOf(array, array.length);
        for (int x = 0; x < arr.length; x++) {
            for (int i = 0, j = 1; j < arr.length; i++, j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }






}
