/*
KADANE'S ALGORITHM
 */
package arrays;
public class MaximumSubarray {
    public static int MaximumSubarray(int[] arr){
        int sum =0;
        int maxSum= Integer.MIN_VALUE;
        for(int i=0; i< arr.length; i++){
            sum=sum+arr[i];
            maxSum= Math.max(maxSum,sum);

            if(sum<0){
                sum=0;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {

        int[] arr = {10, 5, 2, 7, 1, -10};
        System.out.println(MaximumSubarray(arr));

    }

}
