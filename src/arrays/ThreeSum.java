package arrays;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public static ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int sum =0;
        int i=0;
        for (i=0;i<nums.length-2;i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    ans.add(triplet);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                }

            }
        }

        return ans;

    }
    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};

        ArrayList<ArrayList<Integer>> ans = threeSum(nums);

        System.out.println("Triplets are:");

        for (ArrayList<Integer> triplet : ans) {

            System.out.println(triplet);
        }
    }


}
/*
1 fixed + 2 pointers = 3 elements
/*
============================================================
LeetCode 15 : 3Sum
============================================================
BRUTE FORCE
============================================================

Choose 3 elements.

Use 3 loops:

for(i)
    for(j)
        for(k)

Check:

nums[i] + nums[j] + nums[k] == 0

Time  : O(n³)

Duplicates need to be handled.

Can use HashSet to store unique triplets.


============================================================
BETTER APPROACH
============================================================

Fix one element.

Use HashSet to find the remaining two.

For every i:

target = -nums[i]

Then search for two numbers whose sum is target.

Time  : O(n²)

Space : O(n)


============================================================
OPTIMAL APPROACH
============================================================

Sort the array.

Why sorting?

Because Two Pointer depends on the array being sorted.

If:

sum < 0

we need a BIGGER sum.

Move:

left++

Because moving left to the right
increases the value.

--------------------------------

If:

sum > 0

we need a SMALLER sum.

Move:

right--

Because moving right to the left
decreases the value.

Without sorting, we cannot predict
how moving a pointer changes the sum.


============================================================
ALGORITHM
============================================================

1. Sort the array.

2. Fix the first element using i.

3. Skip duplicate i.

4. Set:

left = i + 1
right = n - 1

5. While left < right:

sum = nums[i] + nums[left] + nums[right]

--------------------------------

sum < 0

left++

Need a bigger sum.

--------------------------------

sum > 0

right--

Need a smaller sum.

--------------------------------

sum == 0

Store the triplet.

Then:

left++
right--

Then skip duplicate left
and duplicate right.
============================================================
WHY i > 0?
============================================================
Code:

if (i > 0 && nums[i] == nums[i - 1])
    continue;

IMPORTANT:

i > 0 is about the INDEX,
not about positive/negative numbers.

It does NOT mean:

nums[i] > 0

It simply means:

"There is a previous element to compare with."

Example:

[-4, -1, -1, 0, 1, 2]

i = 1:

-1 != -4

Don't skip.

i = 2:

-1 == -1

Skip.

We are skipping duplicate VALUES,
not negative numbers.


============================================================
WHY SKIP DUPLICATE i?
============================================================
============================================================
WHY SKIP LEFT AND RIGHT DUPLICATES?

Example:

[-2, 0, 0, 2, 2]

After finding:

[-2, 0, 2]

there are duplicate 0s and 2s.

Without skipping them,
the same triplet can be added again.

Therefore:

while (left < right &&
       nums[left] == nums[left - 1])

    left++;


while (left < right &&
       nums[right] == nums[right + 1])

    right--;


============================================================
WHY SKIP DUPLICATES AFTER FINDING A TRIPLET?
============================================================

First store the current valid triplet.

Then move:

left++
right--

Then skip duplicates.

Why?

Because the current combination
must first be checked/stored.

After storing it,
duplicate values would only
produce the SAME triplet again.

============================================================
WHY MOVE BOTH POINTERS AFTER sum == 0?
============================================================

The current left and right
have already produced a valid triplet.

So we need a new pair.

Therefore:

left++
right--

If we don't move them,
we will check the same pair again.

============================================================
COMPLEXITY
============================================================

Sorting:

O(n log n)

Outer loop:

O(n)

Two pointers:

O(n)

Overall:

O(n²)

Space:

O(1) extra space

(excluding output)


============================================================
COMMON MISTAKES
============================================================

❌ left = 0

✔ left = i + 1

❌ Forget sorting

✔ Arrays.sort(nums)

❌ Skip negative numbers

✔ We only skip DUPLICATES.

❌ Skip duplicates before checking sum

✔ Store valid triplet first,
  then skip duplicates.

❌ Store sum

✔ Store:

nums[i]
nums[left]
nums[right]

============================================================
INTERVIEW EXPLANATION
============================================================

"I sort the array first so that I can use
the two-pointer technique.

I fix one element and use left and right
pointers to find the other two elements.

If the sum is less than zero, I move left
to increase the sum.

If the sum is greater than zero, I move
right to decrease the sum.

When the sum is zero, I store the triplet
and skip duplicates to ensure unique answers.

The time complexity is O(n²)."

============================================================
*/
