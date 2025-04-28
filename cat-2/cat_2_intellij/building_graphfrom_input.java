package cat_2_intellij;
import java.util.*;
public class building_graphfrom_input {
    public static void main(String[] args){
        // input -
//        5 4
//        0 1 0 2 1 3 1 4 2 4 null
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        int N = Integer.parseInt(line1[0]);
        int E = Integer.parseInt(line1[1]);
        String[] edges = sc.nextLine().split(" ");
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i =0; i<N; i++){
            adjlist.add(new ArrayList<>());
        }
        for(int i = 0; i<edges.length-1; i+=2){
            if (edges[i].equals("null") || edges[i+1].equals("null")){
                continue;
            }
            int src = Integer.parseInt(edges[i]);
            int dest = Integer.parseInt(edges[i+1]);
            adjlist.get(src).add(dest);
            adjlist.get(dest).add(src);
        }
        int[] visited = new int[N];
        List<Integer> answer = new ArrayList<>();
//        for(int i = 0; i<N; i++){
//            if (visited[i] == 0){
////                answer.add(i);
//                visited[i] = 1;
//                dfs(i, visited, adjlist, answer);
//            }
//        }
        //implementing bfs algorithm -
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = 1;
        while(!queue.isEmpty()) {
            int val = queue.poll();
            answer.add(val);
            for (int nodes : adjlist.get(val)) {
                if (visited[nodes] == 0) {
                    visited[nodes] = 1;
                    queue.add(nodes);
                }
            }
        }
        System.out.println(adjlist);
        System.out.println(answer);
    }
    public static void dfs(int i, int[] visited, List<List<Integer>> adjlist, List<Integer> answer){
        answer.add(i);
        for(int node : adjlist.get(i)){
            if(visited[node] == 0){
                visited[node] = 1;
                dfs(node, visited, adjlist, answer);
            }
        }
    }
}
