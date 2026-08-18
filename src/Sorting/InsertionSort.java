package Sorting;

import java.util.Arrays;

public class InsertionSort {

    // Method to perform Insertion Sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        // Traverse from the 2nd element (index 1) to the end
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift elements of arr[0..i-1] that are greater than 'key'
            // one position ahead to make room for 'key'
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert 'key' into its correct sorted position
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {12, 11, 13, 5, 6};

        System.out.println("Original array: " + Arrays.toString(numbers));

        insertionSort(numbers);

        System.out.println("Sorted array:   " + Arrays.toString(numbers));
    }
}
/*
Pass 1: i = 1
Array at start: [12, 11, 13, 5, 6]
key = arr[1] = 11
j = 1 - 1 = 0
While Loop:Check: j >= 0 (0 >= 0: True) && arr[0] > key (12 > 11: True)
Shift: arr[1] = arr[0]
$\rightarrow$ Array: [12, 12, 13, 5, 6]
Decrement: j = -1
Check: j >= 0 (-1 >= 0: False) $\rightarrow$ Loop ends.
Insert Key: arr[j + 1] = key $\rightarrow$ arr[0] = 11
Array after Pass 1: [11, 12, 13, 5, 6] (11 aur 12 sort ho gaye)
 */
