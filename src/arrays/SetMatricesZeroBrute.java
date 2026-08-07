package arrays;

public class SetMatricesZeroBrute {

    public static void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Traverse the matrix
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                // Found a zero
                if (matrix[i][j] == 0) {

                    markRow(matrix, i, cols);

                    markCol(matrix, j, rows);
                }
            }
        }

        // Convert all -1 into 0
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == -1) {

                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Mark entire row with -1
    public static void markRow(int[][] matrix, int row, int cols) {

        for (int j = 0; j < cols; j++) {

            if (matrix[row][j] != 0) {

                matrix[row][j] = -1;
            }
        }
    }

    // Mark entire column with -1
    public static void markCol(int[][] matrix, int col, int rows) {

        for (int i = 0; i < rows; i++) {

            if (matrix[i][col] != 0) {

                matrix[i][col] = -1;
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        setZeroes(matrix);

        for (int[] row : matrix) {

            for (int num : row) {

                System.out.print(num + " ");
            }

            System.out.println();
        }
    }
}
/*
------------------------------------------------------------
Problem

If a cell is 0, make its entire row and column 0.

------------------------------------------------------------
Brute Force Idea

1. Traverse the matrix.
2. If a 0 is found, mark its row and column with -1.
3. After traversal, convert all -1 to 0.

------------------------------------------------------------
Why mark NON-ZERO elements as -1?

Original 0 must remain unchanged.

If we replace original 0 with -1,
we lose the information about where the
actual zero was.

So,

if(matrix[i][j] != 0)
    matrix[i][j] = -1;

------------------------------------------------------------
Why Brute Force is NOT the Best?

1. Uses -1 as a marker.
   Fails if matrix already contains -1.

2. Every time a 0 is found,
   the entire row and column are traversed again.

So a lot of unnecessary work is repeated.

------------------------------------------------------------
Time Complexity

Traversing matrix = O(m × n)

For every 0,
marking row = O(n)
marking column = O(m)

Worst case:
Every cell is 0.

Total =
O((m × n) × (m + n))

------------------------------------------------------------
Space Complexity

O(1)

No extra arrays are used.

------------------------------------------------------------
Interview Questions

Q. Why use -1?
Ans. To distinguish newly marked cells
from original zeros.

Q. Why not replace with 0 immediately?
Ans. Newly created zeros will also be
treated as original zeros.

Q. Why isn't this the optimal solution?
Ans. It repeatedly traverses rows and
columns and depends on -1 as a marker.

------------------------------------------------------------
Outer Traversal

↓

Zero mila

↓

markRow()

   for loop chala

↓

markCol()

   for loop chala

↓

Outer Traversal continue
Why is it not O(m×n)?
"Although the matrix is scanned once, every time a zero is found,
its entire row and entire column are scanned again. In the worst case,
every cell can be zero, so these extra scans dominate the complexity,
making it O((m×n) × (m+n))."
*/