package Sorting;

public class QuickSort {

    static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            int p = partition(arr, low, high);

            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {

        int pivot = arr[low];

        int i = low;
        int j = high;

        while (i < j) {

            if (arr[i] <= pivot) {
                i++;
            }
            else if (arr[j] > pivot) {
                j--;
            }
            else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Pivot ko correct position par rakho
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

    public static void main(String[] args) {

        int[] arr = {4, 6, 2, 5, 7, 3, 1};

        quickSort(arr, 0, arr.length - 1);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
