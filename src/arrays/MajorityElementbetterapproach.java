package arrays;

public class MajorityElementbetterapproach {

    public static int majorityElement(int[] nums) {

        int candidate = 0;
        int count = 0;

        for (int num : nums) {

            // If count becomes 0,
            // choose current element as new candidate
            if (count == 0) {
                candidate = num;
            }

            // Same candidate gets one vote
            if (num == candidate) {
                count++;
            }

            // Different element cancels one vote
            else {
                count--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        System.out.println(majorityElement(nums));
    }
}

/*
------------------------------------------------------------
Problem

Return the element
that appears
more than n/2 times.

------------------------------------------------------------
Brute Force

Count frequency
of every element.

Return frequency > n/2.

Time : O(n²)

Space : O(1)

------------------------------------------------------------
Better Approach

Use HashMap.

Element -> Frequency

Return element
whose frequency > n/2.

Time : O(n)

Space : O(n)

------------------------------------------------------------
Optimal (Moore Voting)

Observation

Only one element
can appear
more than n/2 times.

Maintain

candidate

count

------------------------------------------------------------
Algorithm

If count becomes 0

Choose current element
as new candidate.

If current element
equals candidate

count++

Else

count--

Return candidate.

------------------------------------------------------------
Why count-- ?

Different element
cancels one vote
of the current candidate.

------------------------------------------------------------
Why does this work?

Majority element
appears more than n/2 times.

Even after all cancellations,

it will still survive.

------------------------------------------------------------
Time Complexity

One traversal

O(n)

------------------------------------------------------------
Space Complexity

O(1)

------------------------------------------------------------
Interview Questions

Q. Why does Moore Voting work?

Ans.

Majority element
has more than half
the votes.

All other elements
can cancel only some votes,
not all.

------------------------------------------------------------
Q. Why don't we verify candidate again?

Ans.

Because the problem guarantees
that a majority element
always exists.

If not guaranteed,
do one more traversal
to verify frequency.

------------------------------------------------------------
Common Mistakes

❌ Forget

count == 0

✔ Change candidate
only when count becomes 0.

❌ Return count

✔ Return candidate.

------------------------------------------------------------
*/
