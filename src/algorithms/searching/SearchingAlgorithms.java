package algorithms.searching;

import java.util.Arrays;

public class SearchingAlgorithms {

    public int linearSearch(int[] arr, int data) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == data) {
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int data, int start, int end) {

        int mid = (end + start) / 2;

        if (data == arr[mid]) return mid;

        else if (data > arr[start] && data <= arr[mid]) {

            return binarySearch(arr, data, start, mid - 1);

        } else if (data > arr[mid] && data <= arr[end]) {

            return binarySearch(arr, data, mid + 1, end);

        }
        return -1;
    }

    public static int binarySearch(int[] arr, int data) {

        return binarySearch(arr, data, 0, arr.length - 1);
    }

    public static int jumpSearch(int[] arr, int data) {

        int step = (int) Math.sqrt(arr.length);

        int start = 0;
        int end = step;

        while (end < arr.length) {
            if (arr[end] == data)
                return end;
            else if (arr[end] > data) {
                for (int i = start; i < end; i++) {
                    if (arr[i] == data) {
                        return i;
                    }
                }
            }
            start = end;
            end += step;

        }

        return -1;
    }


}
