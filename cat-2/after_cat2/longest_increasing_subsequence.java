package after_cat2;

public class longest_increasing_subsequence {
    public static int lis(int index, int prev, int[] arr, int n){
        if (index == n) return 0;
        //not take case -
        int len = 0 + lis(index + 1, prev, arr, n);
        //take the element -
        if (prev == -1 || arr[index] > arr[prev]){
            len = Math.max(len, 1+lis(index+1, index, arr, n));
        }
        return len;

    }
    public static void main(String[] args) {
        int[] arr = {8, 17, 6, 25, 15, 45, 41, 54};
        int ans = lis(0, -1, arr, arr.length);
        System.out.println(ans);
    }
}
