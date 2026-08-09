package arrays;

import java.util.ArrayList;

public class MajorityElementII229 {

    public static ArrayList<Integer> majorityElement(int[] nums) {

        int candidate1 = 0;
        int candidate2 = 0;

        int count1 = 0;
        int count2 = 0;

        // ---------------- First Pass ----------------
        // Find possible candidates

        for (int num : nums) {

            if (num == candidate1) {

                count1++;
            }

            else if (num == candidate2) {

                count2++;
            }

            else if (count1 == 0) {

                candidate1 = num;
                count1 = 1;
            }

            else if (count2 == 0) {

                candidate2 = num;
                count2 = 1;
            }

            else {

                count1--;
                count2--;
            }
        }

        // ---------------- Second Pass ----------------
        // Verify candidates

        count1 = 0;
        count2 = 0;

        for (int num : nums) {

            if (num == candidate1) {

                count1++;
            }

            else if (num == candidate2) {

                count2++;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        if (count1 > nums.length / 3) {

            ans.add(candidate1);
        }

        if (count2 > nums.length / 3) {

            ans.add(candidate2);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1,1,1,3,3,2,2,2};

        System.out.println(majorityElement(nums));
    }
}
/*
The first pass only identifies potential candidates by cancelling votes.
It does not count their actual frequencies. Therefore,
we perform a second pass to verify that the candidates occur more than n/3 times.

The order is important because we must first check whether the current element
is already one of the candidates. If it is, we should increase its vote instead of replacing
a candidate or occupying an empty slot. Only when the element matches neither candidate do we check for empty candidate slots.
If both slots are occupied, we cancel one vote from both candidates.

Interview Questions

Q. Why only 2 candidates?

Q. Why second pass?

Q. Why this order?

Q. Why decrement both counts?

Q. Why O(1) space?

Q. Why not HashMap?
 */