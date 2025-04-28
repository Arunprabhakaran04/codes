package cat_2_intellij;
import java.util.*;

public class topoloical_sort {
    public static void topo_util(int v, List<List<Integer>> adj, boolean[] visited, Stack<Integer>stack){
        visited[v] = true;
        // recurrance for all adj vertices -
        for(int i : adj.get(v)){
            if(!visited[i]){
                topo_util(i, adj, visited, stack);
            }
        }
        stack.push(v);
    }
    public static void topo_sort(List<List<Integer>> lst, int v){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[v];
        for(int i = 0; i<v; i++){
            if(!visited[i]){
                topo_util(i, lst, visited, stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }
    public static void main(String[] args) {
        int v = 5;
        // Edges
        List<List<Integer> > edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(0, 2));
        edges.add(Arrays.asList(2, 4));
        edges.add(Arrays.asList(4, 1));
        edges.add(Arrays.asList(4, 3));
        edges.add(Arrays.asList(1, 3));
        // Graph represented as an adjacency list
        List<List<Integer> > adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for(List<Integer> i : edges){
            adj.get(i.get(0)).add(i.get(1));
        }
        topo_sort(adj, v);


    }
}
