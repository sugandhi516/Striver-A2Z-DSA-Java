package arrays;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }

        return maxCount;
    }
}


// TWO POINTERS APPROACH
class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {

        int left = 0;
        int max = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                left = right + 1;
            } else {
                max = Math.max(max, right - left + 1);
            }
        }

        return max;
    }
}


//Problem: Max Consecutive Ones
//Platform: LeetCode 485
//Difficulty: Easy
//
//Approach:
//1. Traverse the array once.
//2. If the current element is 1, increment the count.
//3. Update the maximum count using Math.max().
//4. If the current element is 0, reset count to 0.
//5. Return the maximum consecutive count.
//
//Time Complexity: O(n)
//Space Complexity: O(1)
//
//Edge Cases:
//1. Array contains all 1s.
//2. Array contains all 0s.
//3. Single element array.
//4. Empty array.
//5. Consecutive 1s at the beginning or end of the array.
//
//Mistake I Made:
//Initially thought of using two pointers, but realized only one traversal with a counter is enough.
//
//Key Learning:
//Whenever a problem asks for the length of a consecutive sequence,
//first think whether a simple counter can solve it before using two pointers.
//
//---------------------------------------------------------
//Interview Questions:
//1. Why is a single counter sufficient instead of two pointers?
//2. What happens if the array contains only 0s?
//3. Why do we reset the counter on encountering 0?
//4. Can this problem be solved recursively? Is it a good idea?
//5. What are the time and space complexities?
//
//Interview Follow-up:
//Q: Can you solve it using two pointers?
//
//A: Yes, but it is unnecessary. Since we only need the length of
//the current streak, a single counter is simpler and achieves the
//same O(n) time and O(1) space complexity. Two pointers also work,
//but they don't provide any additional advantage for this problem.
//---------------------------------------------------------
//*/
