package Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void BubbleSort(int[] arr){
        int n =arr.length;
        for(int i =n-1; i>=0; i--){
            for(int j =0; j<i; j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original array: " + Arrays.toString(numbers));

        BubbleSort(numbers);

        System.out.println("Sorted array:   " + Arrays.toString(numbers));
    }
}
/*
Adjacent Swaps Only: Unlike Selection Sort or Quick Sort, Bubble Sort only
ever compares and exchanges
neighboring items (arr[j] and arr[j+1]).

stable
Best Case: $O(n)$ with the swapped flag optimization (array is already sorted;
 exits after $1$ pass of $n-1$ comparisons).
Without the flag, it is $O(n^2)$.
 */
