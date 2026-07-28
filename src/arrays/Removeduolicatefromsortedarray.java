package arrays;

public class Removeduolicatefromsortedarray {
    public static int Removeduplicate(int[] arr){
        int slow=0;
        for(int fast=1;fast<arr.length;fast++ ){
            if(arr[slow]!=arr[fast]){
                slow++;// hume unique elements retur krne h isliye slow ko increment krdenge(count ki trh)
                arr[slow]=arr[fast];// slow ko next value p move krenge fast ko loop update kraa h
            }
        }
        return slow+1;// slow 0 se start hua tha or hume count return krna h

    }
}
