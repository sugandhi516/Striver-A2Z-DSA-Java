package arrays;
import java.util.HashMap;
public class MajorityElement {
    public int majorityElement(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(int i=0 ; i< arr.length ; i++){
            if(map.get(arr[i])> arr.length/2){
                return arr[i];
            }
        }
        return -1;
    }

}
/*
------------------------------------------------------------
Problem : Majority Element
Platform : LeetCode 169

------------------------------------------------------------
Approach : HashMap

Store the frequency of every element.

Traverse the array again.

If frequency of an element becomes
greater than n/2,

return that element.

Time Complexity

First Traversal

O(n)

Second Traversal

O(n)

Overall

O(2n)

=

O(n)
 */
