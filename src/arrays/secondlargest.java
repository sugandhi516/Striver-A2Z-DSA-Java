/*
Problem: Second Largest Element in an Array
Platform: GFG
Difficulty: Easy

Approach:
1. Maintain max and secondMax.
2. If current element is greater than max:
   - Move old max to secondMax.
   - Update max.
3. Else if current element lies between max and secondMax,
   update secondMax.

Time Complexity: O(n)
Space Complexity: O(1)

Learned:
Always save the old maximum before updating it.
*/
package arrays;

public class secondlargest {
    public static int second(int[] arr){
        if (arr.length < 2) {
            return -1;
        }
        int max= arr[0];
        int secondmax= -1;
        for(int i=1; i<arr.length; i++){
            if(arr[i]>max){
                secondmax=max;
                max= arr[i];
            }
            else if(arr[i]<max && arr[i]>secondmax){
                secondmax=arr[i];
            }
        }
        return secondmax;
    }
}
