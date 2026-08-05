package arrays;

public class NextPermutation31 {

    // Function to find the next permutation
    public static void nextPermutation(int[] nums) {

        int pivot = -1;

        // Step 1: Find the pivot
        // Traverse from right to left
        // Find the first index where nums[i] < nums[i+1]
        for (int i = nums.length - 2; i >= 0; i--) {

            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // Step 2: If no pivot is found,
        // the array is in descending order.
        // Reverse the whole array.
        if (pivot == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // Step 3: Find the first element greater than pivot
        // Traverse from right to left
        for (int i = nums.length - 1; i > pivot; i--) {

            if (nums[i] > nums[pivot]) {

                swap(nums, i, pivot);
                break;
            }
        }

        // Step 4: Reverse the elements after the pivot
        reverse(nums, pivot + 1, nums.length - 1);
    }

    // Function to swap two elements
    public static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Function to reverse the array from left to right
    public static void reverse(int[] nums, int left, int right) {

        while (left < right) {

            swap(nums, left, right);

            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 7, 4, 3, 1};

        nextPermutation(nums);

        System.out.print("Next Permutation: ");

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
/*
Time Complexity

Finding Pivot      -> O(n)

Finding Greater    -> O(n)

Reverse            -> O(n)

Overall

O(n)

------------------------------------------------------------
Space Complexity

O(1)

------------------------------------------------------------
Interview Questions

Q1. Why do we search from the right?

Answer:

Because we want the smallest possible change
to obtain the next permutation.
Searching from the left may skip
many valid permutations.

------------------------------------------------------------

Q2. Why is the suffix always descending?

Answer:

If the suffix had an increasing pair,
we would have found another pivot further right.

Hence,
everything after the pivot
is already in descending order.

------------------------------------------------------------

Q3. Why do we choose the first greater element
from the right?

Answer:

The suffix is descending.

The first element greater than the pivot
from the right
is automatically the smallest element
greater than the pivot.

------------------------------------------------------------

Q4. Why do we reverse instead of sorting?

Answer:

The suffix is already in descending order.

Reversing converts it into ascending order
in O(n).

Sorting would take O(n log n).

------------------------------------------------------------

Q5. Why do we initialize Pivot with -1?

Answer:

If Pivot remains -1 after traversal,

it means no increasing pair exists.

Hence,
the array is already the last permutation.

------------------------------------------------------------

Q6. Why do we reverse only after Pivot?

Answer:

The left part is already correct.

Only the suffix needs to become
the smallest possible arrangement.
 */