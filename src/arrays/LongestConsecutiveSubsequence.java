package arrays;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {

    public static int longestConsecutive(int[] arr) {

        // Store all elements in HashSet
        HashSet<Integer> set = new HashSet<>();

        for (int element : arr) {
            set.add(element);
        }

        int longest = 0;

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {

            // Start a sequence only if previous element doesn't exist
            if (!set.contains(arr[i] - 1)) {

                int current = arr[i];
                int count = 1;

                // Count consecutive elements
                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                // Update longest sequence
                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        int[] arr = {100, 4, 200, 1, 3, 2};

        System.out.println("Longest Consecutive Sequence Length = "
                + longestConsecutive(arr));
    }
}

/*
------------------------------------------------------------
Problem

Find the length of the longest consecutive sequence.

Sequence can be in any order.

------------------------------------------------------------
Approach

1. Store all elements in HashSet.
2. Traverse the array.
3. Start sequence only if (num - 1) is absent.
4. Count using (num + 1).
5. Update longest.

------------------------------------------------------------
Why HashSet?

Searching in HashSet = O(1)

------------------------------------------------------------
Time Complexity

O(n)

------------------------------------------------------------
Space Complexity

O(n)

------------------------------------------------------------
Interview Questions

Q. Why use HashSet?
Ans. O(1) searching.

Q. Why check (num - 1)?
Ans. To start only from the beginning of a sequence.

Q. Why not start from every element?
Ans. Same sequence would be counted multiple times.

Q. Why use while loop?
Ans. To keep extending the sequence until it breaks.

------------------------------------------------------------
Common Mistakes I Made

1. Started from the smallest element only.
   (Wrong. Every valid starting point must be checked.)

2. Used if instead of while.

3. count = 0
   (Correct: count = 1)

4. Used arr[i] + 1 inside while.
   (Correct: current + 1)

5. Forgot current++.

6. Wrote longest = count.
   (Correct: longest = Math.max(longest, count))

7. Wrote if(set.contains(num-1)).
   (Correct: !set.contains(num-1))

8. Used variables outside their scope.

------------------------------------------------------------
*/
