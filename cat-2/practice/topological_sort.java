package practice;
import java.util.*;

public class topological_sort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        // input edges - 0 1 0 2 2 4 4 1 4 3 1 3
        String[] input = sc.nextLine().split(" ");
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adjlist.add(new ArrayList<>());
        }
        for(int i = 0; i<input.length-1; i+=2){
            int index = Integer.parseInt(input[i]);
            adjlist.get(index).add(Integer.parseInt(input[i+1]));
        }
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[n];
        for(int i =0; i<n; i++){
            if(visited[i] == 0){
                dfs(i, stack, visited, adjlist);
            }
        }
        List<Integer> answer = new ArrayList<>();
        while(!stack.isEmpty()){
            answer.add(stack.pop());
        }
        System.out.println(answer);
    }
    public static void dfs(int i, Stack<Integer> stack, int[] visited, List<List<Integer>> adjlist){
        visited[i] = 1;
        for(int ele : adjlist.get(i)){
            if(visited[ele] == 0){
                dfs(ele, stack, visited, adjlist);
            }
        }
        stack.add(i);
    }
}
