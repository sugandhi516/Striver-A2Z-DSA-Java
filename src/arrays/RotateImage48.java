/*
Approach	        Time     	Space
New Matrix	       O(n²)	    O(n²)
Transpose + Reverse	O(n²)	   O(1) ✅

Why does the inner loop start from j = i?
"Because matrix[i][j] and matrix[j][i] represent the same pair.
If I start from j = 0, every pair will be swapped twice, bringing
the matrix back to its original state.
Starting from j = i ensures each pair is swapped only once."

"Initially I thought of creating another matrix,
 but that requires O(n²) extra space. Then I observed that a 90° clockwise
 rotation can be achieved in-place by first transposing the matrix and then reversing
 every row. During transpose, I swap only the upper triangular part (j = i) to avoid
 swapping the same pair twice. After transposing, reversing each row places every
 element in its final rotated position.
This gives O(n²) time and O(1) extra space."
 */
package arrays;

public class RotateImage48 {

    public static void rotate(int[][] matrix) {

        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                swap(matrix, i, left, right);
                left++;
                right--;
            }
        }
    }

    public static void swap(int[][] matrix, int row1, int col1, int row2, int col2) {
        int temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }
    public static void swap(int[][] matrix, int row, int left, int right) {

        int temp = matrix[row][left];
        matrix[row][left] = matrix[row][right];
        matrix[row][right] = temp;
    }
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotate(matrix);

        System.out.println("Rotated Matrix:");

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
leetcode pr helper function nhi use kia code m hi temp leke direct swapping ki h or vhi
clean code h ye bss readablity k liye bada code likha h
------------------------------------------------------------
Brute Force

Create another matrix.

Place every element
at its rotated position.

Time : O(n²)

Space : O(n²)

------------------------------------------------------------
Optimal Observation

90° Clockwise Rotation

=

Transpose

+

Reverse every row

------------------------------------------------------------

Q. Why transpose first?
Transpose converts rows
into columns.
------------------------------------------------------------
Q. Why reverse every row?
Reversing rows completes
90° clockwise rotation.
------------------------------------------------------------
Q. Why j = i ?
To avoid duplicate swaps.
------------------------------------------------------------
*/