package algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

    private static int[] merge(int[] a, int[] b) {

        int[] arr = new int[a.length + b.length];

        int indexA = 0, indexB = 0;

        for (int i = 0; i < arr.length;i++){

            if(indexA == a.length){
                arr[i] = b[indexB];
                indexB++;
            } else if (indexB == b.length) {
                arr[i] = a[indexA];
                indexA++;
            }else if (a[indexA] > b[indexB]){
                arr[i] = b[indexB];
                indexB++;
            }else {
                arr[i] = a[indexA];
                indexA++;
            }

        }

        return arr;
    }

    public static int[] merge(int[] arr) {

        if (arr.length == 1) {
            return arr;
        } else if (arr.length == 2) {
            if(arr[0] > arr[1]){
                int temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp;
                return arr;
            }
            return arr;
        }

        int start = 0;
        int end = arr.length ;
        int mid = start + (end - start) / 2;


        return merge(merge(Arrays.copyOfRange(arr, start, mid)), merge(Arrays.copyOfRange(arr, mid , end)));
    }
}
