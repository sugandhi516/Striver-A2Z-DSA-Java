package arrays;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public static ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int sum =0;
        int i=0;
        for (i=0;i<nums.length-2;i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    ans.add(triplet);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                }

            }
        }

        return ans;

    }
    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};

        ArrayList<ArrayList<Integer>> ans = threeSum(nums);

        System.out.println("Triplets are:");

        for (ArrayList<Integer> triplet : ans) {

            System.out.println(triplet);
        }
    }


}
/*
1 fixed + 2 pointers = 3 elements
 */