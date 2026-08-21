package BinarySearch1D;

public class FloorinaSortedArray {

    public static int findFloor(int[] arr, int x) {

        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] <= x) {
                ans = arr[mid];   // floor candidate
                left = mid + 1;   // aur bada valid element search karo
            }
            else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int x = 11;

        System.out.println("Floor = " + findFloor(arr, x));
    }
}
