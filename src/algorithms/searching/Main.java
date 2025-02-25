package algorithms.searching;

import java.util.Arrays;

import static algorithms.searching.SearchingAlgorithms.binarySearch;

public class Main {
    public static void main(String[] args) {
        int length = 10;
        int[] arr = {2, 5, 8, 12, 19, 21, 29, 31, 40, 51, 67, 82, 103, 125};

        System.out.println(Arrays.toString(arr));

        System.out.println(binarySearch(arr, 51));


    }
}
