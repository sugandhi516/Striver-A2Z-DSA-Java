package arrays;

import java.util.ArrayList;

public class Spiralmatrix {

    public static ArrayList<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> ans = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0;
        int bottom = rows - 1;

        int left = 0;
        int right = cols - 1;

        while (top <= bottom && left <= right) {

            // ---------------- Top Row ----------------

            for (int j = left; j <= right; j++) {
                ans.add(matrix[top][j]);
            }
            top++;

            // ---------------- Right Column ----------------

            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            // ---------------- Bottom Row ----------------

            if (top <= bottom) {

                for (int j = right; j >= left; j--) {
                    ans.add(matrix[bottom][j]);
                }

                bottom--;
            }

            // ---------------- Left Column ----------------

            if (left <= right) {

                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }

                left++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        ArrayList<Integer> ans = spiralOrder(matrix);

        System.out.println(ans);
    }
}

/*
------------------------------------------------------------
Problem

Return all elements
of matrix
in spiral order.

------------------------------------------------------------
Brute Force

Keep visiting cells
using visited array.

Time : O(m × n)

Space : O(m × n)

------------------------------------------------------------
Optimal Observation

Maintain

Top

Bottom

Left

Right

boundaries.

Traverse

Top

↓

Right

↓

Bottom

↓

Left

Repeat until
boundaries cross.

------------------------------------------------------------
Boundaries

top = 0

bottom = rows - 1

left = 0

right = cols - 1

------------------------------------------------------------
Step 1

Traverse Top Row

left → right

matrix[top][j]

top++

------------------------------------------------------------
Step 2

Traverse Right Column

top → bottom

matrix[i][right]

right--

------------------------------------------------------------
Step 3

If(top <= bottom)

Traverse Bottom Row

right → left

matrix[bottom][j]

bottom--

------------------------------------------------------------
Step 4

If(left <= right)

Traverse Left Column

bottom → top

matrix[i][left]

left++

------------------------------------------------------------
Why extra checks?

After updating

top

and

right

boundaries,

remaining rows
or columns
may not exist.

Extra checks prevent

duplicate traversal

and

invalid traversal.

------------------------------------------------------------
Time Complexity

Every element
visited exactly once.

O(m × n)

------------------------------------------------------------
Space Complexity

Only boundaries used.

O(1)

(Output list not counted.)

------------------------------------------------------------
Interview Questions

Q. Why four boundaries?

Ans.

To shrink
the remaining rectangle
after every traversal.

------------------------------------------------------------
Q. Why while(top <= bottom && left <= right)?

Ans.

Loop runs until
all rows and columns
are processed.

------------------------------------------------------------
Q. Why extra checks before Bottom and Left?

Ans.

After updating

top

and

right,

boundaries may cross.

Checks prevent duplicates.

------------------------------------------------------------
Common Mistakes

❌ Forget

top++

✔ Update boundary
after traversal.

❌ Forget

right--

✔ Update every boundary.

❌ Bottom loop

left → right

✔ right → left

❌ Left loop

top → bottom

✔ bottom → top

❌ Forget boundary checks

✔ if(top <= bottom)

✔ if(left <= right)

------------------------------------------------------------
*/