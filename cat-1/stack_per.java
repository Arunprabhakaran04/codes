import java.util.*;
public class stack_per {
    public static void findequal(int[] arr1, int[] arr2){
        int n = arr1.length;
        Stack<Integer> st = new Stack<Integer>();
        int j = 0;
        for(int i = 0; i < n; i++){
            st.push(arr1[i]);
            while(!st.isEmpty() && st.peek() == arr2[j]){
                st.pop();
                j++;
            }

        }
        if(st.isEmpty()){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }

    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int[] arr2 = {2,3,1};
        
        findequal(arr1, arr2);
    }
}
