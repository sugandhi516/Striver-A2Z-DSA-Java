package arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    // ---------------------------------------------------------
    // BRUTE FORCE APPROACH
    // Time Complexity : O(n²)
    // Space Complexity: O(1)
    // ---------------------------------------------------------

    public static int[] bruteForce(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                int sum = nums[i] + nums[j];

                if (sum == target) {

                    int[] ans = {i, j};
                    return ans;
                }
            }
        }

        return new int[]{};
    }


    // ---------------------------------------------------------
    // BETTER APPROACH (Two Pointers)
    //
    // NOTE:
    // This works ONLY for SORTED ARRAYS.
    // It DOES NOT work for the original LeetCode Two Sum
    // because the given array is unsorted.
    //
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ---------------------------------------------------------

    public static int[] twoPointers(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int sum = nums[left] + nums[right];

            if (sum == target) {

                int[] ans = {left, right};
                return ans;
            }

            else if (sum < target) {
                left++;
            }

            else {
                right--;
            }
        }

        return new int[]{};
    }


    // ---------------------------------------------------------
    // OPTIMAL APPROACH (HashMap)
    //
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ---------------------------------------------------------

    public static int[] optimal(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // Current Element
            int first = nums[i];

            // Required Element
            int second = target - first;

            /*
             map.containsKey(second)

             Checks whether the required element
             is already present in the HashMap.
            */

            if (map.containsKey(second)) {

                /*
                 map.get(second)

                 Returns the index of
                 the required element.
                */

                int firstIndex = map.get(second);

                // Current Index
                int secondIndex = i;

                int[] ans = {firstIndex, secondIndex};

                return ans;
            }

            /*
             Store

             Key   -> Number
             Value -> Index

             Example

             2 -> 0
             7 -> 1
             11 -> 2
            */

            map.put(first, i);
        }

        return new int[]{};
    }


    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};

        int target = 9;

        System.out.println("Brute Force : " +
                Arrays.toString(bruteForce(nums, target)));

        /*
         Two Pointer works only for sorted arrays.
         nums is already sorted here.
        */

        System.out.println("Two Pointers : " +
                Arrays.toString(twoPointers(nums, target)));

        System.out.println("HashMap : " +
                Arrays.toString(optimal(nums, target)));
    }
}
