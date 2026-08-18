package Sorting;

import java.util.Arrays;

public class OptimisedBubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        // Outer loop runs from the last index down to 0
        // 'i' marks the right boundary for the current pass
        for (int i = n - 1; i >= 0; i--) {
            boolean swapped = false;

            // Inner loop bubbles the largest element to index 'i'
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // Optimization: if no swaps occurred, array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original array: " + Arrays.toString(numbers));

        bubbleSort(numbers);

        System.out.println("Sorted array:   " + Arrays.toString(numbers));
    }
}
