package practice;
import java.util.*;
public class bellman_ford {
    public static int[] bellmanford(List<List<Integer>> adjlist, int n, int e){
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e8);
        dist[0] = 0;
        for(int i =0; i<n-1; i++){
            for(List<Integer> lst : adjlist){
                int u = lst.get(0);
                int v = lst.get(1);
                int d = lst.get(2);
                if(dist[u] != (int)1e8 && dist[u] + d < dist[v]){
                    dist[v] = dist[u] + d;
                }
            }
        }
        for(List<Integer> lst : adjlist){
            int u = lst.get(0);
            int v = lst.get(1);
            int d = lst.get(2);
            if(dist[u] != (int)1e8 && dist[u] + d < dist[v]){
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int e = Integer.parseInt(temp[1]);
        List<List<Integer>> edges = new ArrayList<>();
        for(int i = 0; i<e; i++) edges.add(new ArrayList<>());
        System.out.println("Enter the edges");
        for(int i =0; i<e; i++){
            String[] edge = sc.nextLine().split(" ");
            int src = Integer.parseInt(edge[0] );
            int dest = Integer.parseInt(edge[1] );
            int distance = Integer.parseInt(edge[2] );
            edges.get(i).add(src);
            edges.get(i).add(dest);
            edges.get(i).add(distance);
        }
        //bellman ford algorithm -
        int[] ans = bellmanford(edges, n, e);
        if (ans.length == 1) System.out.println("negative cycle");
        else System.out.println(Arrays.toString(ans));
    }
}
