package arrays;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayLeaders {
    public static ArrayList<Integer> leaders(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[arr.length-1]);
        int MaxRight= arr[arr.length-1];
        for(int i = arr.length -2; i >=0; i--){
            if(arr[i]>=MaxRight){
                answer.add(arr[i]);
                MaxRight= arr[i];
            }
        }
        Collections.reverse(answer);
        return answer;
    }
    public static void main(String[] args) {

        int[] arr = {16, 17, 4, 3, 5, 2};

        System.out.println(leaders(arr));
    }
}


