/*
leetcode; 189

Approach:
1. Calculate effective rotations using k = k % n.
2. Reverse the entire array.
3. Reverse the first k elements.
4. Reverse the remaining (n-k) elements.

Why k = k % n?
- After every n rotations, the array returns to its original position.
- Therefore, rotating by k positions is the same as rotating by (k % n) positions.

Example:
n = 7, k = 10
k = 10 % 7 = 3
So, rotating 10 times is equivalent to rotating 3 times.

Time Complexity: O(n)
Space Complexity: O(1)

Edge Cases:
1. k > n → Use k = k % n.
2. k = 0 or k % n = 0 → Array remains unchanged.
3. n = 1 → No rotation needed.

Mistake I Made:
Initially thought reversing the entire array alone would rotate it; later learned that reversing the first k and remaining (n-k) elements is also required.

Key Learning:
Reverse the whole array, then reverse the first k elements and the remaining elements to achieve in-place rotation.
*/
package arrays;

public class RotateArray {
    public static void reverse(int[] arr, int i, int j){
        while(i <j){
            int temp=arr[i];
            arr[i] = arr[j];
            arr[j]= temp;
            i++;
            j--;

        }
    }
    public void rotate(int[] arr, int k){
        int n= arr.length;
         k= k%n;
         if(k==0){
             return;
         }
        reverse( arr,0,n-1);
        reverse(arr,0, k-1);
        reverse(arr,k, n-1);
    }

}
