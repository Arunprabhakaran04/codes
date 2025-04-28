package after_cat2;
import java.util.*;
public class subset_sum_problem {
    public static boolean subsetsum(int n, int target, int[] arr){
        if(target == 0) return true;
        if (n == 0) return (target - arr[0] == 0);
        boolean notpick = subsetsum(n-1, target, arr);
        boolean pick = false;
        if (target >= arr[n]){
            pick = subsetsum(n-1, target - arr[n], arr);
        }
        return notpick || pick;
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("enter the target ");
        int k = sc.nextInt();
        boolean ans = subsetsum(n-1, k, arr);
        System.out.println(ans);
    }
}
