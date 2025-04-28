package after_cat2;
import java.util.*;

public class longest_common_subsequence {
    public static List<Character> anslst = new ArrayList<>();
    public static int helper(int x, int y, String st1, String st2, Integer[][] dp){
        if (x == st1.length() || y == st2.length()) return 0;
        if (dp[x][y] != null){
            return dp[x][y];
        }
        if (st1.charAt(x) == st2.charAt(y)){
            return 1 + helper(x+1, y+1, st1, st2, dp);
        }
        int first = helper(x, y+1, st1, st2, dp);
        int second = helper(x+1, y, st1, st2, dp);
        int answer = Math.max(first, second);
        dp[x][y] = answer;
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        String y = sc.nextLine();
        Integer[][] dp = new Integer[x.length()][y.length()];
        System.out.println(helper(0,0,x,y, dp));
        System.out.println(anslst);
    }
}
