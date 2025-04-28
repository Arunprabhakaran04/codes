package after_cat2;
import java.util.*;
public class knapsack_01 {
    public static int solve(int n, int w, int[] weights, int[] values){
        if (n == 0 || w == 0) return 0;
        if (weights[n-1] > w) return solve(n-1, w, weights, values);
        return Math.max(
                values[n-1]+solve(n-1, w-weights[n-1], weights, values), solve(n-1, w, weights, values)
        );
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] weights = new int[n];
        int[] values = new int[n];
        System.out.println("enter the weights ");
        for(int i = 0; i<n; i++){
            weights[i] = sc.nextInt();
        }
        System.out.println("enter the values ");
        for(int i = 0; i<n; i++){
            values[i] = sc.nextInt();
        }
        int ans = solve(n, w, weights, values);
        System.out.println(ans);
    }
}
