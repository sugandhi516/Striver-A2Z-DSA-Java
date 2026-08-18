package Sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // Swap only if a smaller element was found
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    } // <-- Closed selectionSort method here

    public static void main(String[] args) {
        int[] numbers = {64, 25, 12, 22, 11};

        System.out.println("Original array: " + Arrays.toString(numbers));

        selectionSort(numbers);

        System.out.println("Sorted array:   " + Arrays.toString(numbers));
    }
}
/*Unlike Insertion Sort or Quick Sort, whose runtimes change significantly
based on how sorted the array already is,
Selection Sort always executes the exact same number of comparisons.

Selection Sort makes at most $n - 1$ swaps
Number of Swaps $O(n)$ maximum
unstable
Time Complexity:Best Case: $O(n^2)$ — Even if the array is already sorted,
 it still scans the remaining elements to find the minimum
 */
