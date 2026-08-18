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
