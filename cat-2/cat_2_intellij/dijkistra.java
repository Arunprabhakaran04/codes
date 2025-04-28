package cat_2_intellij;

import java.util.ArrayList;
import java.util.*;

class Tuple{
    int u;
    int v;
    Tuple(int u, int v){
        this.u = u;
        this.v = v;

    }
}
public class dijkistra {
    private int v;
    private ArrayList<ArrayList<Tuple>> adj;

    dijkistra(int v){
        this.v = v;
        this.adj = new ArrayList<>();
        for(int i = 0; i<v; i++){
            adj.add(new ArrayList<>());
        }

    }
    public void addedge(int src, int dest, int w){
        adj.get(src).add(new Tuple(dest, w));
        adj.get(dest).add(new Tuple(src, w));
    }

    public void dijkistra_solve(int src){
        PriorityQueue<Tuple> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.v));
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Tuple(src, 0));

        while(!pq.isEmpty()){
            Tuple curr = pq.poll();
            int u = curr.u;
            int d = curr.v;

            if (d > dist[u]) continue;

            for(Tuple neig : adj.get(u)){
                int v = neig.u;
                int weight = neig.v;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Tuple(v, dist[v]));
                }


            }

        }
        System.out.println("Shortest distances from source:");
        for (int i = 0; i < v; i++) {
            System.out.println("Node " + i + " -> " + dist[i]);
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        dijkistra g = new dijkistra(V);

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            g.addedge(u, v, w);
        }

        int src = sc.nextInt();
        g.dijkistra_solve(src);
    }

}
