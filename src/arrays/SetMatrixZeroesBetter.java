package arrays;

public class git staSetMatrixZeroesBetter {

    public static void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Stores which rows and columns should become zero
        boolean[] row = new boolean[rows];
        boolean[] col = new boolean[cols];

        // ---------------- First Traversal ----------------
        // Mark the rows and columns containing 0

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == 0) {

                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // ---------------- Second Traversal ----------------
        // If row OR column is marked, make the cell 0

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (row[i] || col[j]) {

                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 0},
                {4, 5, 6},
                {0, 8, 9}
        };

        setZeroes(matrix);

        System.out.println("Final Matrix:");

        // Print Matrix using normal nested loops

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }
}

/*
------------------------------------------------------------
Problem

If any cell contains 0,
make its entire row and column 0.

------------------------------------------------------------
Better Approach

Step 1

Create two boolean arrays.

row[] -> Stores which rows should become 0.

col[] -> Stores which columns should become 0.

------------------------------------------------------------
Step 2

Traverse the matrix.

If matrix[i][j] == 0

row[i] = true;
col[j] = true;

------------------------------------------------------------
Step 3

Traverse the matrix again.

If row[i] || col[j]

matrix[i][j] = 0;

------------------------------------------------------------
Why OR (||) ?

Question says:

Make the entire row and entire column zero.

If either the row OR the column is marked,
the current cell must become zero.

------------------------------------------------------------
Why not AND (&&) ?

Using AND means

both row and column
must be marked.

Many cells that should become 0
would never become 0.

------------------------------------------------------------
Why boolean arrays?

They simply remember

Which rows?

Which columns?

need to become zero.

------------------------------------------------------------
Time Complexity

First Traversal

O(m × n)

Second Traversal

O(m × n)

Total

O(m × n)

------------------------------------------------------------
Space Complexity

row[] = O(m)

col[] = O(n)

Total

O(m + n)

------------------------------------------------------------
Why Better than Brute Force?

Brute Force

Every time we find a zero,

we traverse its entire row

and

its entire column again.

Better

No repeated row/column traversal.

We only store the information first,

then modify the matrix once.

------------------------------------------------------------
Common Mistakes

❌ boolean row = true;

✔ row[i] = true;

❌ matrix[i][j] == 0;

✔ matrix[i][j] = 0;

❌ if(row[i] && col[j])

✔ if(row[i] || col[j])

❌ if(row[i] == true)

✔ if(row[i])

------------------------------------------------------------
*/
