/*
"Instead of using separate row[] and col[] arrays,
I use the first row and first column of the matrix itself as markers.
Whenever I encounter a zero, I mark its row and column in the
first column and first row. Since matrix[0][0] cannot represent both t
he first row and first column simultaneously,
I use an extra boolean variable for the first column.
Then I process the remaining matrix using these markers and
finally update the first row and first column.
This gives O(m×n) time and O(1) extra space."

Why do we start from 0 in the first traversal but from 1 in the second traversal?
In the first traversal, we need to inspect every original cell,
including the first row and first column, to create the markers.
In the second traversal, the first row and first column already
contain marker information,
so we skip them to avoid overwriting those markers before they are fully used.
 */
package arrays;

public class SetMatrixZeroesoptimal {

    public static void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Stores whether first column should become zero
        boolean firstColZero = false;

        // ---------------- First Traversal ----------------
        // Use first row and first column as markers

        for (int i = 0; i < rows; i++) {

            // Check first column separately
            if (matrix[i][0] == 0) {
                firstColZero = true;
            }

            // Skip first column because it is a marker
            for (int j = 1; j < cols; j++) {

                if (matrix[i][j] == 0) {

                    // Mark row
                    matrix[i][0] = 0;

                    // Mark column
                    matrix[0][j] = 0;
                }
            }
        }

        // ---------------- Second Traversal ----------------
        // Start from (1,1) because first row and first column are markers

        for (int i = 1; i < rows; i++) {

            for (int j = 1; j < cols; j++) {

                if (matrix[i][0] == 0 || matrix[0][j] == 0) {

                    matrix[i][j] = 0;
                }
            }
        }

        // ---------------- Third Step ----------------
        // Make first row zero if required

        if (matrix[0][0] == 0) {

            for (int j = 0; j < cols; j++) {

                matrix[0][j] = 0;
            }
        }

        // ---------------- Fourth Step ----------------
        // Make first column zero if required

        if (firstColZero) {

            for (int i = 0; i < rows; i++) {

                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };

        setZeroes(matrix);

        System.out.println("Final Matrix:");

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
Marker Meaning

matrix[i][0] = 0

=> Row i should become zero.

matrix[0][j] = 0

=> Column j should become zero.

------------------------------------------------------------
Why firstColZero?

matrix[0][0]

belongs to both

First Row

and

First Column.

It cannot store both markers.

So

matrix[0][0]

stores only

First Row marker.

firstColZero

stores

First Column marker.

------------------------------------------------------------
time complexity
First Traversal
O(m × n)
Second Traversal
O(m × n)
First Row
O(n)
First Column
O(m)
Total
O(m × n)
------------------------------------------------------------
Space Complexity

Only one boolean variable

O(1)

------------------------------------------------------------
Interview Questions

Q. Why not row[] and col[]?

Ans.

Matrix itself stores the markers.

------------------------------------------------------------
Q. Why firstColZero?

Ans.

matrix[0][0]

cannot represent both

first row

and

first column.

------------------------------------------------------------
Q. Why start second traversal from (1,1)?

Ans.

Because first row and first column
are marker arrays.

------------------------------------------------------------
*/
