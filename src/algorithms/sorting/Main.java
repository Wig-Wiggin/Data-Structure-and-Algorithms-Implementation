package algorithms.sorting;


import java.util.ArrayList;
import java.util.Arrays;

import static algorithms.sorting.SortingAlgorithms.*;


public class Main {
    public static void main(String[] args) {
        int[] arr = {9,4,2,6,1,7,3,8,5};
  //      int[] arr = {9,4,2};
        int[] result = qSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(result));



    }
}
