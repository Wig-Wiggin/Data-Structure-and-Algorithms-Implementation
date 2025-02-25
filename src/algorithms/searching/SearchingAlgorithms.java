package algorithms.searching;

import java.util.Arrays;

public class SearchingAlgorithms {

    private static int binarySearch(int[] arr, int data, int start, int end) {

        int mid = (end + start) / 2;

        if (data == arr[mid]) return mid;

        else if (data > arr[start] && data <= arr[mid]) {

            return binarySearch(arr, data, start, mid-1);

        } else if (data > arr[mid] && data <= arr[end]) {

            return binarySearch(arr, data, mid+1, end);

        }
        return -1;
    }

    public static int binarySearch(int[] arr, int data) {

        return binarySearch(arr, data, 0, arr.length-1);
    }



}
