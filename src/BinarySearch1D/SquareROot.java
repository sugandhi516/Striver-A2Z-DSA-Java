package BinarySearch1D;

public class SquareROot {
    public static int Squareroot(int n){
        int ans = 0;
        int left=0;
        int right= n;
        while(left<=right){
            int mid =left+(right-left)/2;
            long square = (long) mid * mid;

            if (square == n) {
                return mid;
            }
            else if (square < n) {
                ans = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return ans;

    }
    public static void main(String[] args) {

        int n = 11;

        System.out.println(Squareroot(n));
    }
}
