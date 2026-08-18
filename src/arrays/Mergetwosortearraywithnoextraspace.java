package arrays;
import java.util.Arrays;
public class Mergetwosortearraywithnoextraspace {
    public static void merge( int[] nums1, int m,int n, int[] nums2 ){
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(i>=0 && j>=0 ){
            if(nums1[i]>nums2[j]){
                nums1[k]= nums1[i];
                i--;
            }
            else{
                nums1[k]=nums2[j];
                j--;
            }
        k--;
        }
        while(j>=0){
            nums1[k]=nums2[j];
            j--;
            k--;

        }

    }
    public static void main(String[] args){
        int[] nums1= {1,2,3,0,0,0};
        int[] nums2 = {4,5,6};
        int m=3;
        int n=3;
        merge( nums1,m,n,nums2);
        System.out.println(Arrays.toString(nums1));

    }
}
