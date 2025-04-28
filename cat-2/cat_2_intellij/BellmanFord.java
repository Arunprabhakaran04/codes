package cat_2_intellij;
import java.util.*;

class Edge{
    int src;
    int dest;
    int weight;
    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }
}

class BellmanFord{
    //do bellman iterations -
    public static int[] bellman(List<Edge> edges, int v, int src){
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        //travel v-1 iterations to find the minimum distance
        for(int i =0; i<v-1; i++){
            for(Edge edge:edges){
                if (dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest]){
                    dist[edge.dest] = dist[edge.src] + edge.weight;
                }
            }
        }
        //check for negative cycle -
        for(Edge edge: edges){
            if (dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest]){
                System.out.println("the graph contains negative cycle ");
                return null;
            }

        }
        return dist;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i<e; i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int wei = sc.nextInt();

            edges.add(new Edge(src, dest, wei));
        }
        int src = 0;
        int[] dist = bellman(edges, v, src);

        if(dist != null){
            System.out.println(Arrays.toString(dist));
        }

    }
}