package arrays;

import java.util.HashMap;

public class LongestsubarrayHashmap {

    public static int longestSubarray(int[] arr, int k) {

        /*
         HashMap stores

         Key   -> Prefix Sum
         Value -> First Index where that prefix sum appeared

         Example

         Prefix Sum : 6
         Index      : 3

         Map:

         6 -> 3
        */

        HashMap<Integer, Integer> map = new HashMap<>();


        // Current Prefix Sum
        int sum = 0;

        // Maximum Length
        int maxLength = 0;


        for (int i = 0; i < arr.length; i++) {

            // Calculate Prefix Sum
            sum += arr[i];


            /*
             CASE 1

             If Prefix Sum itself becomes k

             Example

             Prefix Sum = 15
             k = 15

             Then subarray starts from index 0.

             Length = i + 1
            */

            if (sum == k) {
                maxLength = i + 1;
            }


            /*
             CASE 2

             Check whether

             Current Prefix Sum - Previous Prefix Sum = k

             Therefore,

             Previous Prefix Sum = sum - k

             Example

             Current Prefix Sum = 25
             k = 15

             Search for

             25 - 15 = 10

             If Prefix Sum 10 exists,
             then subarray between those indices has sum k.
            */

            if (map.containsKey(sum - k)) {

                /*
                 map.get(sum-k)

                 returns the FIRST index where
                 that prefix sum occurred.

                 Example

                 map

                 10 -> 0
                 15 -> 1
                 17 -> 2

                 map.get(10)

                 returns 0
                */

                int previousIndex = map.get(sum - k);

                int length = i - previousIndex;

                maxLength = Math.max(maxLength, length);
            }


            /*
             Store Prefix Sum only once.

             Why?

             Because we want the FIRST occurrence.

             Earlier index always gives larger length.

             WRONG

             map.put(sum,i);

             This overwrites previous index.

             CORRECT

             Store only if prefix sum
             has never appeared before.
            */

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] arr = {10, 5, 2, 7, 1, -10};

        int k = 15;

        System.out.println("Longest Length = " + longestSubarray(arr, k));

    }

}
