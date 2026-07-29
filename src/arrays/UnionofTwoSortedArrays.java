/*
Problem: Union of Two Sorted Arrays
Platform: GeeksforGeeks
Difficulty: Easy

Approach:
1. Use two pointers (i, j) to traverse both sorted arrays.
2. Compare elements from both arrays.
3. Add the smaller element to the answer using addUnique().
4. If both elements are equal, add it only once and move both pointers.
5. After one array is exhausted, add the remaining unique elements from the other array.

Helper Method:
addUnique() ensures that duplicate elements are not added to the result.

Time Complexity: O(n + m)
Space Complexity: O(n + m)   // For storing the union

Edge Cases:
1. One or both arrays are empty.
2. Arrays contain duplicate elements.
3. Both arrays are identical.
4. No common elements.
5. One array finishes before the other.

Mistake I Made:
Initially tried nested loops (O(n*m)).
Later learned that since both arrays are sorted, the merge (two-pointer) technique gives an O(n+m) solution.

Key Learning:
Whenever two sorted arrays need to be processed together,
think of the Merge step of Merge Sort.

---------------------------------------------------------
Interview Questions:
1. Why is the two-pointer approach better than nested loops?
2. Why can't we simply use a HashSet?
3. Why do we move both pointers when a[i] == b[j]?
4. Why is duplicate checking required before adding an element?
5. What will change if the arrays are not sorted?
6. What are the time and space complexities of both HashSet and two-pointer approaches?
---------------------------------------------------------

Why two pointers? → Arrays are sorted, so we can process them in one pass (O(n+m)).
Why not HashSet? → HashSet is easier but needs extra sorting or loses ordering, and its overall complexity is worse for sorted inputs.
Why move both pointers when equal? → The element is common to both arrays, so include it once and skip both occurrences.
Why duplicate check? → Union should contain only unique elements.
If arrays are unsorted? → Either sort first, or use a HashSet.
Time Complexity? → Two pointers: O(n+m), HashSet + sort: O((n+m) log(n+m))
*/
package arrays;
import java.util.ArrayList;
public class UnionofTwoSortedArrays {
    public static void addUnique(ArrayList<Integer> ans, int value) {
        if (ans.isEmpty() || ans.get(ans.size() - 1) != value) {
            ans.add(value);
        }
    }

    public static ArrayList<Integer> findUnion(int a[], int b[]) {

        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {

            if (a[i] < b[j]) {
                addUnique(ans, a[i]);
                i++;
            }
            else if (a[i] > b[j]) {
                addUnique(ans, b[j]);
                j++;
            }
            else {
                addUnique(ans, a[i]);
                i++;
                j++;
            }
        }

        while (i < a.length) {
            addUnique(ans, a[i]);
            i++;
        }

        while (j < b.length) {
            addUnique(ans, b[j]);
            j++;
        }

        return ans;
    }
}
