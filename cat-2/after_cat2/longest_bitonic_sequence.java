package after_cat2;
import java.util.*;
public class longest_bitonic_sequence {
    public static int longestBitonicSubsequence(int[] arr){
        int n = arr.length;
        int[] lds = new int[n];
        int[] lis = new int[n];
        Arrays.fill(lds, 1);
        Arrays.fill(lis, 1);

        for(int i = 0; i<n; i++){
            for(int prev = 0; prev < i; prev++){
                if (arr[i] > arr[prev] && lis[i] < lis[prev] + 1){
                    lis[i] = lis[prev] + 1;
                }
            }
        }

        for(int i = n-1; i>=0; i--){
            for(int next = i+1; next < n; next++){
                if (arr[i] > arr[next] && lis[i] < lis[next] + 1){
                    lis[i] = lis[next] + 1;
                }
            }
        }
        int maxsum = 0;
        for(int i = 0; i<n; i++){
            maxsum = Math.max(maxsum, lis[i] - lds[i] + 1);
        }
        return maxsum;

    }
    public static void main(String[] args) {
        int[] arr = {8, 17, 6, 25, 15, 45, 41, 54};
        int ans = longestBitonicSubsequence(arr);
        System.out.println(ans);
    }
}
