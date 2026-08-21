package BinarySearch1D;

import java.util.Arrays;
public class FloorandCeilinUnsorted{

    public static int[] findFloorAndCeil(int x, int[] arr) {

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        int floor = -1;
        int ceil = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == x) {
                floor = x;
                ceil = x;
                break;
            }
            else if (arr[mid] < x) {
                floor = arr[mid];
                left = mid + 1;
            }
            else {
                ceil = arr[mid];
                right = mid - 1;
            }
        }

        return new int[]{floor, ceil};
    }

    public static void main(String[] args) {

        int x = 7;
        int[] arr = {5, 6, 8, 9, 6, 5, 5, 6};

        int[] result = findFloorAndCeil(x, arr);

        System.out.println("Floor = " + result[0]);
        System.out.println("Ceil = " + result[1]);
    }
}
