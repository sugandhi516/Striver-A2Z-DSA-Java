package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class foursum {

    public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Fix first element
        for (int i = 0; i < nums.length - 3; i++) {

            // Skip duplicate i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Step 3: Fix second element
            for (int j = i + 1; j < nums.length - 2; j++) {

                // Skip duplicate j
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // Step 4: Two pointers
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {

                    // Use long to avoid integer overflow
                    long sum = (long) nums[i]
                            + nums[j]
                            + nums[left]
                            + nums[right];

                    // Sum is too small
                    if (sum < target) {

                        left++;
                    }

                    // Sum is too large
                    else if (sum > target) {

                        right--;
                    }

                    // Quadruplet found
                    else {

                        ArrayList<Integer> quadruplet = new ArrayList<>();

                        quadruplet.add(nums[i]);
                        quadruplet.add(nums[j]);
                        quadruplet.add(nums[left]);
                        quadruplet.add(nums[right]);

                        ans.add(quadruplet);

                        // Move both pointers
                        left++;
                        right--;

                        // Skip duplicate left values
                        while (left < right &&
                                nums[left] == nums[left - 1]) {

                            left++;
                        }

                        // Skip duplicate right values
                        while (left < right &&
                                nums[right] == nums[right + 1]) {

                            right--;
                        }
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};

        int target = 0;

        ArrayList<ArrayList<Integer>> ans = fourSum(nums, target);

        System.out.println("Quadruplets are:");

        for (ArrayList<Integer> quadruplet : ans) {

            System.out.println(quadruplet);
        }
    }
}
/*
============================================================
LeetCode 18 : 4Sum
============================================================

Problem:

Find all UNIQUE quadruplets such that:

nums[i] + nums[j] + nums[left] + nums[right]
== target


============================================================
BRUTE FORCE
============================================================

Choose 4 elements.

Use 4 loops:

for(i)
    for(j)
        for(k)
            for(l)

Check:

sum == target

Time : O(n⁴)


============================================================
BETTER APPROACH
============================================================

Fix 2 elements.

Use HashSet for the remaining pair.

Structure:

i
j
HashSet

Time  : O(n³)

Space : O(n)


============================================================
OPTIMAL APPROACH
============================================================

Same idea as 3Sum,
but now we fix TWO elements.

3Sum:

Fix 1 element
+
2 pointers

4Sum:

Fix 2 elements
+
2 pointers


Structure:

i
 ↓
j
 ↓
left      right


============================================================
ALGORITHM
============================================================

1. Sort the array.

2. Fix first element using i.

3. Skip duplicate i.

4. Fix second element using j.

5. Skip duplicate j.

6. Set:

left = j + 1
right = n - 1

7. Calculate:

sum = nums[i]
    + nums[j]
    + nums[left]
    + nums[right]

8. Compare sum with target.


============================================================
POINTER MOVEMENT
============================================================

If:

sum < target

We need a BIGGER sum.

Therefore:

left++

Because array is sorted,
moving left rightward
increases the value.


--------------------------------

If:

sum > target

We need a SMALLER sum.

Therefore:

right--

Because array is sorted,
moving right leftward
decreases the value.


--------------------------------

If:

sum == target

Store quadruplet.

Then:

left++
right--

Then skip duplicate left
and duplicate right.


============================================================
WHY SORT?
============================================================

Sorting makes pointer movement predictable.

sum < target

→ left++

→ sum increases


sum > target

→ right--

→ sum decreases

Without sorting,
we don't know whether moving
a pointer will increase or decrease
the sum.


============================================================
WHY TWO OUTER LOOPS?
============================================================

We need 4 numbers.

Two are fixed:

nums[i]
nums[j]

Two are found using:

left
right

Therefore:

for(i)
    for(j)
        while(left < right)


============================================================
WHY j STARTS AT i + 1?
============================================================

i is already selected.

So j must come after i.

Therefore:

j = i + 1

This also prevents reusing
the same index.


============================================================
WHY left = j + 1?
============================================================

i and j are already selected.

So left must start after j.

Therefore:

left = j + 1


============================================================
WHY j > i + 1?
============================================================

Code:

if (j > i + 1 &&
    nums[j] == nums[j - 1])

    continue;


j starts from:

i + 1

We DON'T want to skip the very first
possible j position.

Why?

Because nums[j] can legitimately equal nums[i].

Example:

[-2, -2, 1, 3]

Using:

i = 0
j = 1

is completely valid.

So we only skip duplicate j
AFTER its first possible position.


============================================================
WHY SKIP DUPLICATE i?
============================================================

Example:

[-2, -2, 0, 1, 3]

If i points to the first -2,
we explore all quadruplets
starting with -2.

If i points to the second -2,
we would generate the same
quadruplets again.

Therefore skip duplicate i.


============================================================
WHY SKIP DUPLICATE j?
============================================================

Same idea.

For a fixed i:

j = 1 → -1

j = 2 → -1

Both would search the same
remaining elements and produce
the same quadruplets.

So skip duplicate j.


============================================================
WHY SKIP LEFT/RIGHT DUPLICATES?
============================================================

After finding:

[a, b, c, d]

duplicate c or d values
can produce the same quadruplet.

Therefore:

left++
right--

then skip duplicates.


============================================================
WHY SKIP DUPLICATES AFTER
FINDING A QUADRUPLET?
============================================================

First store the valid quadruplet.

Then move pointers.

Then skip duplicate values.

We don't skip the current values
before checking them because they may
form the valid quadruplet.


============================================================
WHY USE long FOR SUM?
============================================================

Use:

long sum

instead of:

int sum

because adding four integers can
cause integer overflow.

Example:

nums can contain very large values.

Therefore:

long sum = (long) nums[i]
         + nums[j]
         + nums[left]
         + nums[right];


============================================================
WHY second pass?
============================================================

Unlike Majority Element,
4Sum does NOT need a second pass.

We directly find a valid quadruplet
when:

sum == target

So:

No verification pass needed.


============================================================
COMPLEXITY
============================================================

Sorting:

O(n log n)

Two outer loops:

O(n²)

Two pointers:

O(n)

Overall:

O(n³)

Space:

O(1) extra space

(excluding output)


============================================================
3SUM vs 4SUM
============================================================

3Sum:

for(i)
    while(left < right)


4Sum:

for(i)
    for(j)
        while(left < right)


3Sum:

1 fixed + 2 pointers


4Sum:

2 fixed + 2 pointers


Complexity:

3Sum → O(n²)

4Sum → O(n³)


============================================================
INTERVIEW EXPLANATION
============================================================

"For 4Sum, I first sort the array so that
I can use two pointers.

I fix two elements using two loops,
then use left and right pointers to find
the remaining two elements.

If the sum is less than target, I move
left to increase the sum.

If the sum is greater than target, I move
right to decrease the sum.

When the sum equals target, I store the
quadruplet and skip duplicates.

The overall time complexity is O(n³)
with O(1) extra space excluding output."


============================================================
COMMON MISTAKES
============================================================

❌ sum < 0

✔ sum < target

❌ sum > 0

✔ sum > target

❌ right++

✔ right--

❌ right = nums.length

✔ right = nums.length - 1

❌ left = 0

✔ left = j + 1

❌ Forget duplicate j

✔ j > i + 1

❌ Store the sum

✔ Store all 4 numbers

❌ int sum

✔ long sum

❌ Duplicate skipping outside
   sum == target

✔ Skip after finding quadruplet.

============================================================
*/