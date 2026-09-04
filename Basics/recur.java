import java.util.Arrays;

public class recur{
    public static int sum(int[] arr){
        if (arr.length == 0){
            return 0;
        }
        return arr[0] + sum(Arrays.copyOfRange(arr, 1, arr.length));
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        System.out.println(sum(arr));
    }
}