package arrays;

public class Segregate0and1 {
    public void Segregate(int[]arr){
        int i=0;
        int j= arr.length-1;
        while(i<=j){
            if(arr[i]==0){
                i++;
            }
            else if(arr[j]==1){
                j--;
            }
            else{
                int temp= arr[i];
                arr[i]= arr[j];
                arr[j]= temp;
            }
        }
    }
}
//GFG
