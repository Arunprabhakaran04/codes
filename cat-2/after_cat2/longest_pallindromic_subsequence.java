package after_cat2;
import java.util.*;
public class longest_pallindromic_subsequence {
    public static int lcs(int x, int y, String st, String str, Integer[][] dp){
        if (x == st.length() || y == str.length()) return 0;
        if (dp[x][y] != null) return dp[x][y];
        if(st.charAt(x) == str.charAt(y)){
            return dp[x][y] = 1 + lcs(x+1, y+1, st, str, dp);
        }
        int first = lcs(x+1, y, st, str, dp);
        int second = lcs(x, y+1, st, str, dp);
        return dp[x][y] = Math.max(first, second);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Integer[][] dp = new Integer[input.length()][input.length()];
        String revinput = new StringBuilder(input).reverse().toString();
        int ans = lcs(0, 0, input, revinput, dp);
        System.out.println(ans);
    }
}
