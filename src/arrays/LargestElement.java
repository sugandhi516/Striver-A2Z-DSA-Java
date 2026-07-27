/*
Problem: Largest Element in Array
Platform: GFG
Difficulty: Easy

Approach:
- Initialize max with first element.
- Traverse the array once.
- Update max whenever a larger element is found.

Time Complexity: O(n)
Space Complexity: O(1)

What I Learned:
Always initialize max with arr[0], not 0.
*/
package arrays;

public class LargestElement {
    public static int largest(int[] arr){
        int max = arr[0];
        for(int i=1; i<arr.length;i++){
            if(arr[i]>max){
                max= arr[i];
            }

        }
        return max;

    }

}
/*
Interview Tip:
Think about:
- Negative numbers
- Duplicate values
- Single element array
*/





