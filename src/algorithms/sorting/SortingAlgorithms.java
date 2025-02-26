package algorithms.sorting;

import java.util.ArrayList;
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

    private static int[] arrayCombine(int[] x, int pivot, int[] y) {
        int[] result = new int[x.length + y.length + 1];
        int counter = 0;
        for (int i = 0; i < x.length; i++) {
            result[counter++] = x[i];

        }
        result[counter++] = pivot;
        for (int i = 0; i < y.length; i++) {
            result[counter++] = y[i];
        }
        return result;
    }

    private static int[] qSortInternal(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }

        int pivot = arr[(arr.length )/2];
        ArrayList<Integer> lesser = new ArrayList<>();
        ArrayList<Integer> bigger = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (pivot < arr[i]) {
                bigger.add(arr[i]);
            } else {
                lesser.add(arr[i]);
            }
        }


        return arrayCombine(qSortInternal(lesser.stream().mapToInt(i -> i).toArray()), pivot, qSortInternal(bigger.stream().mapToInt(i -> i).toArray()));
    }

    public static int[] qSort(int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length);


        return qSortInternal(temp);
    }
}
