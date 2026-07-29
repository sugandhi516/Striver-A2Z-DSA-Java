/*

Platform: LeetCode 283
Approach:
1. Use two pointers: left and right.
2. right traverses the entire array.
3. Whenever a non-zero element is found, swap it with the element at left.
4. Increment left after every non-zero element.
5. By the end, all non-zero elements are at the beginning and all zeroes are shifted to the end.

Time Complexity: O(n)
Space Complexity: O(1)

Edge Cases:
1. Array with all zeroes.
2. Array with no zeroes.
3. Consecutive zeroes.
4. Single element array.
5. Empty array.

Mistake I Made:
Initially thought of searching the next non-zero element for every zero, but learned that maintaining a write pointer (left) gives a simpler one-pass O(n) solution.

Key Learning:
Using one pointer to traverse the array and another to track the next position for a non-zero element efficiently preserves the relative order of non-zero elements while moving all zeroes to the end.
*/
package arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums){
        int left=0;
        for(int right=0; right<nums.length; right++){
            if(nums[right]!=0){
                int temp = nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                left++;
            }
        }
    }
}
