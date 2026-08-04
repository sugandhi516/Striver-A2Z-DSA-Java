package arrays;

public class Besttimetobuyandsell {
    public static int maxProfit(int[] arr){
        int minprice = arr[0];
        int maxprofit=0;
        for(int i=0; i<arr.length;i++){
            if(arr[i]<minprice){
                minprice= arr[i];
            }
            int profit= arr[i] - minprice;
            maxprofit=Math.max(maxprofit,profit);
        }
        return maxprofit;
    }
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, -10};
        System.out.println(maxProfit(arr));

    }

}
