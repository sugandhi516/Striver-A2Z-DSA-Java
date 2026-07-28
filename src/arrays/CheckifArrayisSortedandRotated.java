/*
Problem: Check if Array Is Sorted and Rotated
Platform: LeetCode 1752
Difficulty: Easy

Approach:
1. Traverse the array once.
2. Count the number of places where nums[i] > nums[(i + 1) % n].
3. If the count is more than 1, the array cannot be sorted and rotated.
4. Otherwise, return true.

Time Complexity: O(n)
Space Complexity: O(1)

Mistakes I Made:
1. Used 'int n = nums.length - 1' instead of 'nums.length'.
2. Wrote nums[i + 1 % n] instead of nums[(i + 1) % n].
3. Forgot ')' in the method declaration.
4. Didn't understand why the last element should be compared with the first.
   Learned that '% n' makes the array circular, so the last element
   is compared with the first element.

Key Learning:
Always use (i + 1) % n when checking circular arrays.
*/
package arrays;

public class CheckifArrayisSortedandRotated {
    public static boolean Rotated(int[] nums){
        int count =0;
        int n= nums.length;
        for(int i=0; i<nums.length;i++){
            if(nums[i] > nums[(i+1)%n]){
                count++;
            }
        }
        if(count<=1){
            return true;
        }
        else{
            return false;
        }

    }
}
