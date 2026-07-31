package arrays;

public class LongestSubarraywithsumkpositive {

    public static int longestSubarray(int[] arr, int k) {

        // Left pointer of the window
        int left = 0;

        // Current window sum
        int sum = 0;

        // Stores maximum length found
        int maxLength = 0;

        // Expand the window by moving right pointer
        for (int right = 0; right < arr.length; right++) {

            // Add current element to window
            sum += arr[right];

            /*
             If window sum becomes greater than k,
             shrink the window from the left side.

             This works ONLY because all numbers are positive.
             Removing elements always decreases the sum.
            */
            while (sum > k) {
                sum -= arr[left];
                left++;
            }

            // If current window sum becomes exactly k
            if (sum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 1, 1, 1};

        int k = 3;

        System.out.println("Longest Length = " + longestSubarray(arr, k));
    }
}

/*Why Sliding Window fails for negative numbers?

Example

10 5 2 7 1 -10

When sum becomes 17, Sliding Window removes 10.

Later -10 comes and the total becomes 15 again.

        But 10 has already been removed.

Hence Sliding Window misses the answer.*/
