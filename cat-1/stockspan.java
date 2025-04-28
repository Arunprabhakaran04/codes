import java.util.*;

public class stockspan {
    public static void main(String[] args) {
        int[] price = {10,4,5,90,120,80};
        int n = price.length;
        Stack<Integer> s = new Stack<Integer>();
        int[] sprice = new int[n];
        sprice[0] = 1;
        s.push(0);
        for(int i =1; i< n; i++){
            while(!s.isEmpty() && price[s.peek()] <= price[i]){
                s.pop();
            }
            sprice[i] = ((s.isEmpty()) ? (i+1):(i-s.peek()));
            s.push(i);
        }
        System.out.println(Arrays.toString(sprice));
    }
}
