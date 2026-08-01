package arrays;

import java.util.Arrays;

public class SortColors {

    // ---------------------------------------------------------
    // BRUTE FORCE APPROACH
    // Bubble Sort
    //
    // Idea:
    // Compare every pair of adjacent elements.
    // If left element > right element,
    // swap them.
    //
    // Bubble Sort repeatedly pushes the
    // largest element towards the end.
    //
    // Time Complexity : O(n²)
    // Space Complexity: O(1)
    // ---------------------------------------------------------

    public static void bruteForce(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = 0; j < nums.length - i - 1; j++) {

                if (nums[j] > nums[j + 1]) {

                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                }
            }
        }
    }


    // ---------------------------------------------------------
    // BETTER APPROACH
    // Counting Sort
    //
    // Since array contains only
    // 0,1 and 2,
    // count their frequencies.
    //
    // Then overwrite the array.
    //
    // Time Complexity : O(2n)
    //                = O(n)
    //
    // Space Complexity : O(1)
    // ---------------------------------------------------------

    public static void countingApproach(int[] nums) {

        int zero = 0;
        int one = 0;
        int two = 0;


        // Count frequencies

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                zero++;
            }

            else if (nums[i] == 1) {
                one++;
            }

            else {
                two++;
            }
        }


        /*
         Overwrite the array

         First place all 0s

         Then all 1s

         Then all 2s
        */

        int index = 0;

        while (zero > 0) {

            nums[index] = 0;

            index++;

            zero--;
        }


        while (one > 0) {

            nums[index] = 1;

            index++;

            one--;
        }


        while (two > 0) {

            nums[index] = 2;

            index++;

            two--;
        }

    }



    // ---------------------------------------------------------
    // OPTIMAL APPROACH
    // Dutch National Flag Algorithm
    //
    // low  -> End of 0's region
    //
    // mid  -> Current element
    //
    // high -> Beginning of 2's region
    //
    // Time Complexity : O(n)
    //
    // Space Complexity : O(1)
    // ---------------------------------------------------------

    public static void dutchNationalFlag(int[] nums) {

        int low = 0;

        int mid = 0;

        int high = nums.length - 1;


        while (mid <= high) {

            // Current element is 0

            if (nums[mid] == 0) {

                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;

                mid++;
            }


            // Current element is 1

            else if (nums[mid] == 1) {

                mid++;
            }


            // Current element is 2

            else {

                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;

                /*
                 DO NOT increment mid.

                 Because the element coming
                 from the right side
                 has not been checked yet.
                */

            }

        }

    }



    public static void main(String[] args) {

        int[] arr1 = {2,0,2,1,1,0};

        int[] arr2 = {2,0,2,1,1,0};

        int[] arr3 = {2,0,2,1,1,0};


        bruteForce(arr1);

        countingApproach(arr2);

        dutchNationalFlag(arr3);


        System.out.println("Brute Force : " + Arrays.toString(arr1));

        System.out.println("Counting : " + Arrays.toString(arr2));

        System.out.println("Dutch National Flag : " + Arrays.toString(arr3));

    }

}
