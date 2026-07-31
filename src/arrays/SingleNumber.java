package arrays;

import java.util.HashMap;

public class SingleNumber{

    public static int singleNumber(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count Frequency
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Find the element whose frequency is 1
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1) {
                return nums[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {4, 1, 2, 1, 2};

        System.out.println("Single Number = " + singleNumber(nums));
    }
}
/*
------------------------------------------------------------
Problem: Single Number
Platform: LeetCode 136
Difficulty: Easy
------------------------------------------------------------

Approach:
1. Create a HashMap.
2. Store each number as the key.
3. Store its frequency as the value.
4. Traverse the array again.
5. Return the element whose frequency is 1.

------------------------------------------------------------
Dry Run

nums = [2,2,1]

Iteration 1:
2 -> 1

Iteration 2:
2 -> 2

Iteration 3:
1 -> 1

HashMap

2 -> 2
1 -> 1

Frequency of 1 is 1
Answer = 1

------------------------------------------------------------
Why getOrDefault()?

map.getOrDefault(nums[i], 0)

If the key exists:
Returns its current frequency.

Example:
2 -> 3

map.getOrDefault(2,0)
returns 3.

If the key does not exist:
Returns 0.

------------------------------------------------------------
Why not map.get()?

Wrong:

map.put(nums[i], map.get(nums[i]) + 1);

Suppose map is empty.

nums[i] = 2

map.get(2)

returns

null

Java tries

null + 1

which throws

NullPointerException

Using getOrDefault() avoids this.

------------------------------------------------------------
Time Complexity:
O(n)

Space Complexity:
O(n)

------------------------------------------------------------
Interview Questions

1. Why HashMap?
Ans:
To store the frequency of each element.

2. Why getOrDefault() instead of get()?
Ans:
get() returns null if the key is absent.
getOrDefault() returns 0 and prevents NullPointerException.

3. Why is Space Complexity O(n)?
Ans:
In the worst case, every element is unique, so HashMap stores n key-value pairs.

4. Can this be solved without extra space?
Ans:
Yes. Using XOR in O(n) Time and O(1) Space.

------------------------------------------------------------
Key Learning

• HashMap stores Key-Value pairs.
• Key = Array element.
• Value = Frequency.
• getOrDefault() safely handles missing keys.
• Frequency problems are commonly solved using HashMap.
ye  striver  n XOR method se bhi solve kia h vo seekh lena

------------------------------------------------------------
*/