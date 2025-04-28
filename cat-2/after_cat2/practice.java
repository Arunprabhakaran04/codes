package after_cat2;
import com.sun.security.jgss.GSSUtil;

import java.util.*;
public class practice {
    public static int knap(int[] weights, int[] values, int n, int w){
        if (n < 0 || w == 0) return 0;
        if(weights[n] > w) return knap(weights, values, n-1, w);

        int nottake = knap(weights, values, n-1, w);
        int take = values[n] + knap(weights, values, n-1, w-weights[n]);
        return Math.max(take, nottake);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the total Weight ");
        int w = sc.nextInt();
        System.out.println("enter the values ");
        int[] values = new int[n];
        for(int i =0; i<n; i++){
            values[i] = sc.nextInt();
        }
        System.out.println(knap(arr, values, n-1, w));
    }
}
