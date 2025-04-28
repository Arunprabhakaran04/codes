import java.util.*;
public class max_sliding {
    public static void main(String[] args) {
        int[] arr = {1,6,8,2,0,4,37,25};
        int k = 3;

        ArrayList<Integer> lst = new ArrayList<>();
        for(int i = 0; i<=arr.length-k; i++){
            int maxi = arr[i];
            for(int j = i+1; j<i+k; j++){
                if(arr[j] > maxi){
                    maxi = arr[j];
                }
            }
            lst.add(maxi);
        }
        System.out.println(lst);
    }
}
