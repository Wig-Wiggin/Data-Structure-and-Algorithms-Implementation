package algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
    private static int[] qSortInternal(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }

        int pivot = arr[(arr.length) / 2];
        ArrayList<Integer> lesser = new ArrayList<>();
        ArrayList<Integer> bigger = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length / 2) continue; // Skip pivot element
            if (pivot < arr[i]) {
                bigger.add(arr[i]);
            } else {
                lesser.add(arr[i]);
            }
        }

        int[] sortedLesser = qSortInternal(lesser.stream().mapToInt(i -> i).toArray());
        int[] sortedBigger = qSortInternal(bigger.stream().mapToInt(i -> i).toArray());

        int[] result = new int[sortedLesser.length + sortedBigger.length + 1];

        System.arraycopy(sortedLesser, 0, result, 0, sortedLesser.length);
        result[sortedLesser.length] = pivot;
        System.arraycopy(sortedBigger, 0, result, sortedLesser.length + 1, sortedBigger.length);

        return result;
    }

    public static int[] qSort(int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length);
        return qSortInternal(temp);
    }
}