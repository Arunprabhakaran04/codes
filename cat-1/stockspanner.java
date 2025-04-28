import java.util.*;
class Pair{
    int value;
    int index;
    Pair(int value, int index){
        this.value = value;
        this.index = index;
    }
}
public class stockspanner {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {97,64,32,11,22,56};
        int max = 0;
        int[] stock = new int[n];
        Stack<Pair> stack = new Stack<>();
        for(int i = 0;i<n; i++){
            while(!stack.isEmpty() && stack.peek().value <= arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                stock[i] = i+1;
            }
            else{
                stock[i] = i - stack.peek().index;
            }
            stack.push(new Pair(arr[i], i));
        }
        System.out.println(Arrays.toString(stock));

    }
}
