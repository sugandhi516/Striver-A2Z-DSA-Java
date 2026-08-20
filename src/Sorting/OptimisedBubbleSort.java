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
/*
Pass 1: i = 4 (Inner loop runs for j = 0 to j = 3)
Array at start: [64, 34, 25, 12, 22]swapped = false
j = 0: Compare arr[0] (64) & arr[1] (34)64 > 34 $\rightarrow$ True $\rightarrow$ Swap
$\rightarrow$ Array: [34, 64, 25, 12, 22], swapped = truej = 1:
Compare arr[1] (64) & arr[2] (25)64 > 25 $\rightarrow$ True $\rightarrow$ Swap
$\rightarrow$ Array: [34, 25, 64, 12, 22], swapped = truej = 2: Compare arr[2] (64) & arr[3] (12)64 > 12 $\rightarrow$ True $\rightarrow$ Swap
 $\rightarrow$ Array: [34, 25, 12, 64, 22], swapped = truej = 3: Compare arr[3] (64) & arr[4] (22)64 > 22 $\rightarrow$ True $\rightarrow$ Swap
  $\rightarrow$ Array: [34, 25, 12, 22, 64], swapped = trueEnd of Pass 1 Check: swapped is true $\rightarrow$ Continue.
  Array after Pass 1: [34, 25, 12, 22, 64] (Largest element 64 last index par pahunch gaya)
 */
