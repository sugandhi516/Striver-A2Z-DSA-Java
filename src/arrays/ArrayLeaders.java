package arrays;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayLeaders {
    public static ArrayList<Integer> leaders(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[arr.length-1]);
        int MaxRight= arr[arr.length-1];
        for(int i = arr.length -2; i >=0; i--){
            if(arr[i]>=MaxRight){
                answer.add(arr[i]);
                MaxRight= arr[i];
            }
        }
        Collections.reverse(answer);
        return answer;
    }
    public static void main(String[] args) {

        int[] arr = {16, 17, 4, 3, 5, 2};

        System.out.println(leaders(arr));
    }
}
/*
Problem

Return all leaders in the array.

Leader = Element greater than or equal to
all elements on its right.

------------------------------------------------------------
Approach

1. Traverse from right.
2. Maintain maxRight.
3. If current >= maxRight,
   add to answer.
4. Update maxRight.
5. Reverse answer.

------------------------------------------------------------
Time Complexity

O(n)

------------------------------------------------------------
Space Complexity

O(n)

------------------------------------------------------------
Interview Questions

Q. Why traverse from right?
Ans. Leaders depend on right-side elements.

Q. Why maintain maxRight?
Ans. To avoid checking all right elements again.

Q. Why reverse the answer?
Ans. We collect leaders from right to left.

Q. Why >= and not > ?
Ans. Leader can be equal to right elements.

------------------------------------------------------------
Common Mistakes I Made

1. Used int[] instead of ArrayList.

2. maxRight = arr.length-1
   (Stored index instead of value.)

3. Used Integer.MAX_VALUE.
   (Should use rightmost value or Integer.MIN_VALUE.)

4. Forgot return answer.

5. Forgot Collections.reverse(answer).

6. Used answer.length
   (Use answer.size() for ArrayList.)

------------------------------------------------------------
 */


